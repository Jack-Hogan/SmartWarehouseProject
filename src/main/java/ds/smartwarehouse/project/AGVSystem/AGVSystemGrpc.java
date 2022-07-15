package ds.smartwarehouse.project.AGVSystem;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: AGVSystem.proto")
public final class AGVSystemGrpc {

  private AGVSystemGrpc() {}

  public static final String SERVICE_NAME = "AGVSystem";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest,
      ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse> getVehicleTrackingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "vehicleTracking",
      requestType = ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest.class,
      responseType = ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest,
      ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse> getVehicleTrackingMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest, ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse> getVehicleTrackingMethod;
    if ((getVehicleTrackingMethod = AGVSystemGrpc.getVehicleTrackingMethod) == null) {
      synchronized (AGVSystemGrpc.class) {
        if ((getVehicleTrackingMethod = AGVSystemGrpc.getVehicleTrackingMethod) == null) {
          AGVSystemGrpc.getVehicleTrackingMethod = getVehicleTrackingMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest, ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AGVSystem", "vehicleTracking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AGVSystemMethodDescriptorSupplier("vehicleTracking"))
                  .build();
          }
        }
     }
     return getVehicleTrackingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest,
      ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse> getAgvProductivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "agvProductivity",
      requestType = ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest.class,
      responseType = ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest,
      ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse> getAgvProductivityMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest, ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse> getAgvProductivityMethod;
    if ((getAgvProductivityMethod = AGVSystemGrpc.getAgvProductivityMethod) == null) {
      synchronized (AGVSystemGrpc.class) {
        if ((getAgvProductivityMethod = AGVSystemGrpc.getAgvProductivityMethod) == null) {
          AGVSystemGrpc.getAgvProductivityMethod = getAgvProductivityMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest, ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "AGVSystem", "agvProductivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AGVSystemMethodDescriptorSupplier("agvProductivity"))
                  .build();
          }
        }
     }
     return getAgvProductivityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.AGVDiagRequest,
      ds.smartwarehouse.project.AGVSystem.AGVDiagResponse> getAgvDiagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "agvDiag",
      requestType = ds.smartwarehouse.project.AGVSystem.AGVDiagRequest.class,
      responseType = ds.smartwarehouse.project.AGVSystem.AGVDiagResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.AGVDiagRequest,
      ds.smartwarehouse.project.AGVSystem.AGVDiagResponse> getAgvDiagMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.AGVSystem.AGVDiagRequest, ds.smartwarehouse.project.AGVSystem.AGVDiagResponse> getAgvDiagMethod;
    if ((getAgvDiagMethod = AGVSystemGrpc.getAgvDiagMethod) == null) {
      synchronized (AGVSystemGrpc.class) {
        if ((getAgvDiagMethod = AGVSystemGrpc.getAgvDiagMethod) == null) {
          AGVSystemGrpc.getAgvDiagMethod = getAgvDiagMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.AGVSystem.AGVDiagRequest, ds.smartwarehouse.project.AGVSystem.AGVDiagResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "AGVSystem", "agvDiag"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.AGVSystem.AGVDiagRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.AGVSystem.AGVDiagResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AGVSystemMethodDescriptorSupplier("agvDiag"))
                  .build();
          }
        }
     }
     return getAgvDiagMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AGVSystemStub newStub(io.grpc.Channel channel) {
    return new AGVSystemStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AGVSystemBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AGVSystemBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AGVSystemFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AGVSystemFutureStub(channel);
  }

  /**
   */
  public static abstract class AGVSystemImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest> vehicleTracking(
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getVehicleTrackingMethod(), responseObserver);
    }

    /**
     */
    public void agvProductivity(ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAgvProductivityMethod(), responseObserver);
    }

    /**
     */
    public void agvDiag(ds.smartwarehouse.project.AGVSystem.AGVDiagRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.AGVDiagResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAgvDiagMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVehicleTrackingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest,
                ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse>(
                  this, METHODID_VEHICLE_TRACKING)))
          .addMethod(
            getAgvProductivityMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest,
                ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse>(
                  this, METHODID_AGV_PRODUCTIVITY)))
          .addMethod(
            getAgvDiagMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.smartwarehouse.project.AGVSystem.AGVDiagRequest,
                ds.smartwarehouse.project.AGVSystem.AGVDiagResponse>(
                  this, METHODID_AGV_DIAG)))
          .build();
    }
  }

  /**
   */
  public static final class AGVSystemStub extends io.grpc.stub.AbstractStub<AGVSystemStub> {
    private AGVSystemStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AGVSystemStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AGVSystemStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AGVSystemStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.VehicleTrackingRequest> vehicleTracking(
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getVehicleTrackingMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void agvProductivity(ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAgvProductivityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void agvDiag(ds.smartwarehouse.project.AGVSystem.AGVDiagRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.AGVDiagResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAgvDiagMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AGVSystemBlockingStub extends io.grpc.stub.AbstractStub<AGVSystemBlockingStub> {
    private AGVSystemBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AGVSystemBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AGVSystemBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AGVSystemBlockingStub(channel, callOptions);
    }

    /**
     */
    public ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse agvProductivity(ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest request) {
      return blockingUnaryCall(
          getChannel(), getAgvProductivityMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ds.smartwarehouse.project.AGVSystem.AGVDiagResponse> agvDiag(
        ds.smartwarehouse.project.AGVSystem.AGVDiagRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getAgvDiagMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AGVSystemFutureStub extends io.grpc.stub.AbstractStub<AGVSystemFutureStub> {
    private AGVSystemFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AGVSystemFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AGVSystemFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AGVSystemFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse> agvProductivity(
        ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAgvProductivityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AGV_PRODUCTIVITY = 0;
  private static final int METHODID_AGV_DIAG = 1;
  private static final int METHODID_VEHICLE_TRACKING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AGVSystemImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AGVSystemImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AGV_PRODUCTIVITY:
          serviceImpl.agvProductivity((ds.smartwarehouse.project.AGVSystem.AGVProductivityRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.AGVProductivityResponse>) responseObserver);
          break;
        case METHODID_AGV_DIAG:
          serviceImpl.agvDiag((ds.smartwarehouse.project.AGVSystem.AGVDiagRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.AGVDiagResponse>) responseObserver);
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
        case METHODID_VEHICLE_TRACKING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.vehicleTracking(
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.AGVSystem.VehicleTrackingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AGVSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AGVSystemBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.smartwarehouse.project.AGVSystem.NewAGVSystemImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AGVSystem");
    }
  }

  private static final class AGVSystemFileDescriptorSupplier
      extends AGVSystemBaseDescriptorSupplier {
    AGVSystemFileDescriptorSupplier() {}
  }

  private static final class AGVSystemMethodDescriptorSupplier
      extends AGVSystemBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AGVSystemMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AGVSystemGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AGVSystemFileDescriptorSupplier())
              .addMethod(getVehicleTrackingMethod())
              .addMethod(getAgvProductivityMethod())
              .addMethod(getAgvDiagMethod())
              .build();
        }
      }
    }
    return result;
  }
}
