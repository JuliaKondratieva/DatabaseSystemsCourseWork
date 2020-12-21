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
    comments = "Source: AcceptorLearner.proto")
public final class AcceptorLearnServiceGrpc {

  private AcceptorLearnServiceGrpc() {}

  public static final String SERVICE_NAME = "com.julieandco.grpc.AcceptorLearnService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.julieandco.grpc.AcceptorAcceptNotif,
      com.julieandco.grpc.LearnerResponse> METHOD_ACCEPTNSEND =
      io.grpc.MethodDescriptor.<com.julieandco.grpc.AcceptorAcceptNotif, com.julieandco.grpc.LearnerResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.julieandco.grpc.AcceptorLearnService", "acceptnsend"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.julieandco.grpc.AcceptorAcceptNotif.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.julieandco.grpc.LearnerResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AcceptorLearnServiceStub newStub(io.grpc.Channel channel) {
    return new AcceptorLearnServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AcceptorLearnServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AcceptorLearnServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AcceptorLearnServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AcceptorLearnServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AcceptorLearnServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void acceptnsend(com.julieandco.grpc.AcceptorAcceptNotif request,
        io.grpc.stub.StreamObserver<com.julieandco.grpc.LearnerResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ACCEPTNSEND, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ACCEPTNSEND,
            asyncUnaryCall(
              new MethodHandlers<
                com.julieandco.grpc.AcceptorAcceptNotif,
                com.julieandco.grpc.LearnerResponse>(
                  this, METHODID_ACCEPTNSEND)))
          .build();
    }
  }

  /**
   */
  public static final class AcceptorLearnServiceStub extends io.grpc.stub.AbstractStub<AcceptorLearnServiceStub> {
    private AcceptorLearnServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AcceptorLearnServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AcceptorLearnServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AcceptorLearnServiceStub(channel, callOptions);
    }

    /**
     */
    public void acceptnsend(com.julieandco.grpc.AcceptorAcceptNotif request,
        io.grpc.stub.StreamObserver<com.julieandco.grpc.LearnerResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ACCEPTNSEND, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AcceptorLearnServiceBlockingStub extends io.grpc.stub.AbstractStub<AcceptorLearnServiceBlockingStub> {
    private AcceptorLearnServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AcceptorLearnServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AcceptorLearnServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AcceptorLearnServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.julieandco.grpc.LearnerResponse acceptnsend(com.julieandco.grpc.AcceptorAcceptNotif request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ACCEPTNSEND, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AcceptorLearnServiceFutureStub extends io.grpc.stub.AbstractStub<AcceptorLearnServiceFutureStub> {
    private AcceptorLearnServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AcceptorLearnServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AcceptorLearnServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AcceptorLearnServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.julieandco.grpc.LearnerResponse> acceptnsend(
        com.julieandco.grpc.AcceptorAcceptNotif request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ACCEPTNSEND, getCallOptions()), request);
    }
  }

  private static final int METHODID_ACCEPTNSEND = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AcceptorLearnServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AcceptorLearnServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ACCEPTNSEND:
          serviceImpl.acceptnsend((com.julieandco.grpc.AcceptorAcceptNotif) request,
              (io.grpc.stub.StreamObserver<com.julieandco.grpc.LearnerResponse>) responseObserver);
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

  private static final class AcceptorLearnServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.julieandco.grpc.AcceptorLearner.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AcceptorLearnServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AcceptorLearnServiceDescriptorSupplier())
              .addMethod(METHOD_ACCEPTNSEND)
              .build();
        }
      }
    }
    return result;
  }
}
