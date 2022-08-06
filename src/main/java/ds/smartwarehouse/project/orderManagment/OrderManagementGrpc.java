package ds.smartwarehouse.project.orderManagment;

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
    comments = "Source: orderManagement.proto")
public final class OrderManagementGrpc {

  private OrderManagementGrpc() {}

  public static final String SERVICE_NAME = "OrderManagement";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.StockRequest,
      ds.smartwarehouse.project.orderManagment.StockResponse> getStockCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stockCheck",
      requestType = ds.smartwarehouse.project.orderManagment.StockRequest.class,
      responseType = ds.smartwarehouse.project.orderManagment.StockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.StockRequest,
      ds.smartwarehouse.project.orderManagment.StockResponse> getStockCheckMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.StockRequest, ds.smartwarehouse.project.orderManagment.StockResponse> getStockCheckMethod;
    if ((getStockCheckMethod = OrderManagementGrpc.getStockCheckMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getStockCheckMethod = OrderManagementGrpc.getStockCheckMethod) == null) {
          OrderManagementGrpc.getStockCheckMethod = getStockCheckMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.orderManagment.StockRequest, ds.smartwarehouse.project.orderManagment.StockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OrderManagement", "stockCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagment.StockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagment.StockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("stockCheck"))
                  .build();
          }
        }
     }
     return getStockCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.StockReplenishRequest,
      ds.smartwarehouse.project.orderManagment.StockReplenishResponse> getReplenishStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "replenishStock",
      requestType = ds.smartwarehouse.project.orderManagment.StockReplenishRequest.class,
      responseType = ds.smartwarehouse.project.orderManagment.StockReplenishResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.StockReplenishRequest,
      ds.smartwarehouse.project.orderManagment.StockReplenishResponse> getReplenishStockMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.StockReplenishRequest, ds.smartwarehouse.project.orderManagment.StockReplenishResponse> getReplenishStockMethod;
    if ((getReplenishStockMethod = OrderManagementGrpc.getReplenishStockMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getReplenishStockMethod = OrderManagementGrpc.getReplenishStockMethod) == null) {
          OrderManagementGrpc.getReplenishStockMethod = getReplenishStockMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.orderManagment.StockReplenishRequest, ds.smartwarehouse.project.orderManagment.StockReplenishResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "OrderManagement", "replenishStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagment.StockReplenishRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagment.StockReplenishResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("replenishStock"))
                  .build();
          }
        }
     }
     return getReplenishStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.OrderTrackingRequest,
      ds.smartwarehouse.project.orderManagment.OrderTrackingResponse> getOrderTrackingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "orderTracking",
      requestType = ds.smartwarehouse.project.orderManagment.OrderTrackingRequest.class,
      responseType = ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.OrderTrackingRequest,
      ds.smartwarehouse.project.orderManagment.OrderTrackingResponse> getOrderTrackingMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagment.OrderTrackingRequest, ds.smartwarehouse.project.orderManagment.OrderTrackingResponse> getOrderTrackingMethod;
    if ((getOrderTrackingMethod = OrderManagementGrpc.getOrderTrackingMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getOrderTrackingMethod = OrderManagementGrpc.getOrderTrackingMethod) == null) {
          OrderManagementGrpc.getOrderTrackingMethod = getOrderTrackingMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.orderManagment.OrderTrackingRequest, ds.smartwarehouse.project.orderManagment.OrderTrackingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "OrderManagement", "orderTracking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagment.OrderTrackingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("orderTracking"))
                  .build();
          }
        }
     }
     return getOrderTrackingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderManagementStub newStub(io.grpc.Channel channel) {
    return new OrderManagementStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderManagementBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OrderManagementBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderManagementFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OrderManagementFutureStub(channel);
  }

  /**
   */
  public static abstract class OrderManagementImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void stockCheck(ds.smartwarehouse.project.orderManagment.StockRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.StockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStockCheckMethod(), responseObserver);
    }

    /**
     * <pre>
     *server-to-client streaming
     * </pre>
     */
    public void replenishStock(ds.smartwarehouse.project.orderManagment.StockReplenishRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.StockReplenishResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReplenishStockMethod(), responseObserver);
    }

    /**
     * <pre>
     *client-to-server streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.OrderTrackingRequest> orderTracking(
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.OrderTrackingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getOrderTrackingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStockCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.smartwarehouse.project.orderManagment.StockRequest,
                ds.smartwarehouse.project.orderManagment.StockResponse>(
                  this, METHODID_STOCK_CHECK)))
          .addMethod(
            getReplenishStockMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.smartwarehouse.project.orderManagment.StockReplenishRequest,
                ds.smartwarehouse.project.orderManagment.StockReplenishResponse>(
                  this, METHODID_REPLENISH_STOCK)))
          .addMethod(
            getOrderTrackingMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.smartwarehouse.project.orderManagment.OrderTrackingRequest,
                ds.smartwarehouse.project.orderManagment.OrderTrackingResponse>(
                  this, METHODID_ORDER_TRACKING)))
          .build();
    }
  }

  /**
   */
  public static final class OrderManagementStub extends io.grpc.stub.AbstractStub<OrderManagementStub> {
    private OrderManagementStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public void stockCheck(ds.smartwarehouse.project.orderManagment.StockRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.StockResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStockCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server-to-client streaming
     * </pre>
     */
    public void replenishStock(ds.smartwarehouse.project.orderManagment.StockReplenishRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.StockReplenishResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReplenishStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client-to-server streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.OrderTrackingRequest> orderTracking(
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.OrderTrackingResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getOrderTrackingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class OrderManagementBlockingStub extends io.grpc.stub.AbstractStub<OrderManagementBlockingStub> {
    private OrderManagementBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public ds.smartwarehouse.project.orderManagment.StockResponse stockCheck(ds.smartwarehouse.project.orderManagment.StockRequest request) {
      return blockingUnaryCall(
          getChannel(), getStockCheckMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server-to-client streaming
     * </pre>
     */
    public java.util.Iterator<ds.smartwarehouse.project.orderManagment.StockReplenishResponse> replenishStock(
        ds.smartwarehouse.project.orderManagment.StockReplenishRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getReplenishStockMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class OrderManagementFutureStub extends io.grpc.stub.AbstractStub<OrderManagementFutureStub> {
    private OrderManagementFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderManagementFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderManagementFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderManagementFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *unary
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.smartwarehouse.project.orderManagment.StockResponse> stockCheck(
        ds.smartwarehouse.project.orderManagment.StockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getStockCheckMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STOCK_CHECK = 0;
  private static final int METHODID_REPLENISH_STOCK = 1;
  private static final int METHODID_ORDER_TRACKING = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderManagementImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderManagementImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STOCK_CHECK:
          serviceImpl.stockCheck((ds.smartwarehouse.project.orderManagment.StockRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.StockResponse>) responseObserver);
          break;
        case METHODID_REPLENISH_STOCK:
          serviceImpl.replenishStock((ds.smartwarehouse.project.orderManagment.StockReplenishRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.StockReplenishResponse>) responseObserver);
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
        case METHODID_ORDER_TRACKING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.orderTracking(
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagment.OrderTrackingResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OrderManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderManagementBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.smartwarehouse.project.orderManagment.NewOrderManagementImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderManagement");
    }
  }

  private static final class OrderManagementFileDescriptorSupplier
      extends OrderManagementBaseDescriptorSupplier {
    OrderManagementFileDescriptorSupplier() {}
  }

  private static final class OrderManagementMethodDescriptorSupplier
      extends OrderManagementBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderManagementMethodDescriptorSupplier(String methodName) {
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
      synchronized (OrderManagementGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderManagementFileDescriptorSupplier())
              .addMethod(getStockCheckMethod())
              .addMethod(getReplenishStockMethod())
              .addMethod(getOrderTrackingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
