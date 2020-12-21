package com.julieandco.grpc

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class AcceptorLearnerGrpcImpl : AcceptorLearnServiceGrpc.AcceptorLearnServiceImplBase()  {
    override fun acceptnsend(request: AcceptorAcceptNotif?, responseObserver: StreamObserver<LearnerResponse>?) {
        //super.acceptnsend(request, responseObserver)
        val value=request?.value
        val response = LearnerResponse.newBuilder()
                .build()
        println("Value $value has been chosen")
        responseObserver?.onNext(response);
    }
}