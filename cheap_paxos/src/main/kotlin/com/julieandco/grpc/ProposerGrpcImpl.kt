package com.julieandco.grpc

import com.julieandco.ReceivedInfo
import com.julieandco.StoreInfo
import io.grpc.ManagedChannelBuilder
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class ProposerGrpcImpl : ProposerAcceptorServiceGrpc.ProposerAcceptorServiceImplBase() {
    val receiveddata = ReceivedInfo().receivedmap
    val portslist = StoreInfo().mainportlist

    override fun prepare(request: ProposersPrepareRequest?, responseObserver: StreamObserver<AcceptorsResponce>?) {
        //super.prepare(request, responseObserver)
        val number = request?.number
        val value=request?.value
        var case3 : Boolean = true

        //case1 if no other requests have been seen

        if(receiveddata.isEmpty()) {
            case3=false
            val response = AcceptorsResponce.newBuilder()
                    .setPrepareResponse("prepare")
                    .setIgnored(null)
                    .setValueofhighestprop(0)
                    .setHighestproposal(0)
                    .build()

            responseObserver?.onNext(response);
        }
        else { //case 2 if acceptor has seen higher values
            for ((k, v) in receiveddata) {
                //println("$k = $v")
                if(k> number!!){
                    case3=false
                    val response = AcceptorsResponce.newBuilder()
                            .setPrepareResponse(null)
                            .setIgnored("ignore")
                            .setValueofhighestprop(0)
                            .setHighestproposal(0)
                            .build()

                    responseObserver?.onNext(response);
                    break
                }
            }

        }
        if(case3) {
            //case 3 acceptor hasn't seen higher value
            //val maxnum = receiveddata.maxByOrNull { receiveddata->receiveddata.key }
            //val maxvalbynum = receiveddata.get(maxnum)
            var maxf=0
            for ((k, v) in receiveddata){
                if(k>maxf)
                    maxf=k
            }
            val maxvalbykey= receiveddata[maxf]

            val response = maxvalbykey?.let {
                AcceptorsResponce.newBuilder()
                        .setPrepareResponse("propose")
                        .setIgnored(null)
                        .setValueofhighestprop(it)
                        .setHighestproposal(maxf)
                        .build()
            }

            responseObserver?.onNext(response);
        }
        if (number != null) {
            if (value != null) {
                receiveddata.put(number, value)
            }
        }
    }

    override fun accept(request: ProposersAcceptRequest?, responseObserver: StreamObserver<ProposersAcceptResponse>?) {
        //super.accept(request, responseObserver)
        val number = request?.number
        val value=request?.value
        var ignored:Boolean=false

        //case 1 ignored if promised before
        for ((k, v) in receiveddata) {
            if(k> number!!){
                ignored=true
                val response = ProposersAcceptResponse.newBuilder()
                        .build()

                responseObserver?.onNext(response);
                break
            }
        }
        //case 2 send value to learner
        if(!ignored) {
            val portsIterator = portslist.iterator()

            while (portsIterator.hasNext()) {
                //println(numbersIterator.next())

                val channel = ManagedChannelBuilder.forAddress("host", portsIterator.next())
                        .usePlaintext()
                        .build()

                val stub: AcceptorLearnServiceGrpc.AcceptorLearnServiceBlockingStub = AcceptorLearnServiceGrpc.newBlockingStub(channel)
                val learnerresponse: LearnerResponse = stub.acceptnsend(value?.let {
                    AcceptorAcceptNotif.newBuilder()
                            .setValue(it)
                            .build()
                })
            }
        }
    }
}