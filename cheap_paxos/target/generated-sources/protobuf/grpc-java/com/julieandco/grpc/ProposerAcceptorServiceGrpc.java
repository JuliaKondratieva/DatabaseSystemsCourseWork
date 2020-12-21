package com.julieandco.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: ProposerAcceptor.proto")
public final class ProposerAcceptorServiceGrpc {

  private ProposerAcceptorServiceGrpc() {}

  public static final String SERVICE_NAME = "com.julieandco.grpc.ProposerAcceptorService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.julieandco.grpc.ProposersPrepareRequest,
      com.julieandco.grpc.AcceptorsResponce> METHOD_PREPARE =
      io.grpc.MethodDescriptor.<com.julieandco.grpc.ProposersPrepareRequest, com.julieandco.grpc.AcceptorsResponce>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.julieandco.grpc.ProposerAcceptorService", "prepare"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.julieandco.grpc.ProposersPrepareRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.julieandco.grpc.AcceptorsResponce.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.julieandco.grpc.ProposersAcceptRequest,
      com.julieandco.grpc.ProposersAcceptResponse> METHOD_ACCEPT =
      io.grpc.MethodDescriptor.<com.julieandco.grpc.ProposersAcceptRequest, com.julieandco.grpc.ProposersAcceptResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.julieandco.grpc.ProposerAcceptorService", "accept"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.julieandco.grpc.ProposersAcceptRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.julieandco.grpc.ProposersAcceptResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProposerAcceptorServiceStub newStub(io.grpc.Channel channel) {
    return new ProposerAcceptorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProposerAcceptorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProposerAcceptorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProposerAcceptorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProposerAcceptorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProposerAcceptorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void prepare(com.julieandco.grpc.ProposersPrepareRequest request,
        io.grpc.stub.StreamObserver<com.julieandco.grpc.AcceptorsResponce> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PREPARE, responseObserver);
    }

    /**
     */
    public void accept(com.julieandco.grpc.ProposersAcceptRequest request,
        io.grpc.stub.StreamObserver<com.julieandco.grpc.ProposersAcceptResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACCEPT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PREPARE,
            asyncUnaryCall(
              new MethodHandlers<
                com.julieandco.grpc.ProposersPrepareRequest,
                com.julieandco.grpc.AcceptorsResponce>(
                  this, METHODID_PREPARE)))
          .addMethod(
            METHOD_ACCEPT,
            asyncUnaryCall(
              new MethodHandlers<
                com.julieandco.grpc.ProposersAcceptRequest,
                com.julieandco.grpc.ProposersAcceptResponse>(
                  this, METHODID_ACCEPT)))
          .build();
    }
  }

  /**
   */
  public static final class ProposerAcceptorServiceStub extends io.grpc.stub.AbstractStub<ProposerAcceptorServiceStub> {
    private ProposerAcceptorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProposerAcceptorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProposerAcceptorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProposerAcceptorServiceStub(channel, callOptions);
    }

    /**
     */
    public void prepare(com.julieandco.grpc.ProposersPrepareRequest request,
        io.grpc.stub.StreamObserver<com.julieandco.grpc.AcceptorsResponce> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PREPARE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void accept(com.julieandco.grpc.ProposersAcceptRequest request,
        io.grpc.stub.StreamObserver<com.julieandco.grpc.ProposersAcceptResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACCEPT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProposerAcceptorServiceBlockingStub extends io.grpc.stub.AbstractStub<ProposerAcceptorServiceBlockingStub> {
    private ProposerAcceptorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProposerAcceptorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProposerAcceptorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProposerAcceptorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.julieandco.grpc.AcceptorsResponce prepare(com.julieandco.grpc.ProposersPrepareRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PREPARE, getCallOptions(), request);
    }

    /**
     */
    public com.julieandco.grpc.ProposersAcceptResponse accept(com.julieandco.grpc.ProposersAcceptRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACCEPT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProposerAcceptorServiceFutureStub extends io.grpc.stub.AbstractStub<ProposerAcceptorServiceFutureStub> {
    private ProposerAcceptorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProposerAcceptorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProposerAcceptorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProposerAcceptorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.julieandco.grpc.AcceptorsResponce> prepare(
        com.julieandco.grpc.ProposersPrepareRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PREPARE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.julieandco.grpc.ProposersAcceptResponse> accept(
        com.julieandco.grpc.ProposersAcceptRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACCEPT, getCallOptions()), request);
    }
  }

  private static final int METHODID_PREPARE = 0;
  private static final int METHODID_ACCEPT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProposerAcceptorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProposerAcceptorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PREPARE:
          serviceImpl.prepare((com.julieandco.grpc.ProposersPrepareRequest) request,
              (io.grpc.stub.StreamObserver<com.julieandco.grpc.AcceptorsResponce>) responseObserver);
          break;
        case METHODID_ACCEPT:
          serviceImpl.accept((com.julieandco.grpc.ProposersAcceptRequest) request,
              (io.grpc.stub.StreamObserver<com.julieandco.grpc.ProposersAcceptResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class ProposerAcceptorServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.julieandco.grpc.ProposerAcceptor.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProposerAcceptorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProposerAcceptorServiceDescriptorSupplier())
              .addMethod(METHOD_PREPARE)
              .addMethod(METHOD_ACCEPT)
              .build();
        }
      }
    }
    return result;
  }
}
