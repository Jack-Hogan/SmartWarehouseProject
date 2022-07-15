package ds.smartwarehouse.project.orderManagement;

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
  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.StockRequest,
      ds.smartwarehouse.project.orderManagement.StockResponse> getStockCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "stockCheck",
      requestType = ds.smartwarehouse.project.orderManagement.StockRequest.class,
      responseType = ds.smartwarehouse.project.orderManagement.StockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.StockRequest,
      ds.smartwarehouse.project.orderManagement.StockResponse> getStockCheckMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.StockRequest, ds.smartwarehouse.project.orderManagement.StockResponse> getStockCheckMethod;
    if ((getStockCheckMethod = OrderManagementGrpc.getStockCheckMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getStockCheckMethod = OrderManagementGrpc.getStockCheckMethod) == null) {
          OrderManagementGrpc.getStockCheckMethod = getStockCheckMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.orderManagement.StockRequest, ds.smartwarehouse.project.orderManagement.StockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "OrderManagement", "stockCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagement.StockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagement.StockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("stockCheck"))
                  .build();
          }
        }
     }
     return getStockCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.StockReplenishRequest,
      ds.smartwarehouse.project.orderManagement.StockReplenishResponse> getReplenishStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "replenishStock",
      requestType = ds.smartwarehouse.project.orderManagement.StockReplenishRequest.class,
      responseType = ds.smartwarehouse.project.orderManagement.StockReplenishResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.StockReplenishRequest,
      ds.smartwarehouse.project.orderManagement.StockReplenishResponse> getReplenishStockMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.StockReplenishRequest, ds.smartwarehouse.project.orderManagement.StockReplenishResponse> getReplenishStockMethod;
    if ((getReplenishStockMethod = OrderManagementGrpc.getReplenishStockMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getReplenishStockMethod = OrderManagementGrpc.getReplenishStockMethod) == null) {
          OrderManagementGrpc.getReplenishStockMethod = getReplenishStockMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.orderManagement.StockReplenishRequest, ds.smartwarehouse.project.orderManagement.StockReplenishResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "OrderManagement", "replenishStock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagement.StockReplenishRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagement.StockReplenishResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderManagementMethodDescriptorSupplier("replenishStock"))
                  .build();
          }
        }
     }
     return getReplenishStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.OrderTrackingRequest,
      ds.smartwarehouse.project.orderManagement.OrderTrackingResponse> getOrderTrackingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "orderTracking",
      requestType = ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.class,
      responseType = ds.smartwarehouse.project.orderManagement.OrderTrackingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.OrderTrackingRequest,
      ds.smartwarehouse.project.orderManagement.OrderTrackingResponse> getOrderTrackingMethod() {
    io.grpc.MethodDescriptor<ds.smartwarehouse.project.orderManagement.OrderTrackingRequest, ds.smartwarehouse.project.orderManagement.OrderTrackingResponse> getOrderTrackingMethod;
    if ((getOrderTrackingMethod = OrderManagementGrpc.getOrderTrackingMethod) == null) {
      synchronized (OrderManagementGrpc.class) {
        if ((getOrderTrackingMethod = OrderManagementGrpc.getOrderTrackingMethod) == null) {
          OrderManagementGrpc.getOrderTrackingMethod = getOrderTrackingMethod = 
              io.grpc.MethodDescriptor.<ds.smartwarehouse.project.orderManagement.OrderTrackingRequest, ds.smartwarehouse.project.orderManagement.OrderTrackingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "OrderManagement", "orderTracking"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.smartwarehouse.project.orderManagement.OrderTrackingResponse.getDefaultInstance()))
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
    public void stockCheck(ds.smartwarehouse.project.orderManagement.StockRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.StockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStockCheckMethod(), responseObserver);
    }

    /**
     * <pre>
     *server-to-client streaming
     * </pre>
     */
    public void replenishStock(ds.smartwarehouse.project.orderManagement.StockReplenishRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.StockReplenishResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReplenishStockMethod(), responseObserver);
    }

    /**
     * <pre>
     *client-to-server streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.OrderTrackingRequest> orderTracking(
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.OrderTrackingResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getOrderTrackingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStockCheckMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.smartwarehouse.project.orderManagement.StockRequest,
                ds.smartwarehouse.project.orderManagement.StockResponse>(
                  this, METHODID_STOCK_CHECK)))
          .addMethod(
            getReplenishStockMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.smartwarehouse.project.orderManagement.StockReplenishRequest,
                ds.smartwarehouse.project.orderManagement.StockReplenishResponse>(
                  this, METHODID_REPLENISH_STOCK)))
          .addMethod(
            getOrderTrackingMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.smartwarehouse.project.orderManagement.OrderTrackingRequest,
                ds.smartwarehouse.project.orderManagement.OrderTrackingResponse>(
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
    public void stockCheck(ds.smartwarehouse.project.orderManagement.StockRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.StockResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getStockCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *server-to-client streaming
     * </pre>
     */
    public void replenishStock(ds.smartwarehouse.project.orderManagement.StockReplenishRequest request,
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.StockReplenishResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getReplenishStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *client-to-server streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.OrderTrackingRequest> orderTracking(
        io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.OrderTrackingResponse> responseObserver) {
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
    public ds.smartwarehouse.project.orderManagement.StockResponse stockCheck(ds.smartwarehouse.project.orderManagement.StockRequest request) {
      return blockingUnaryCall(
          getChannel(), getStockCheckMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *server-to-client streaming
     * </pre>
     */
    public java.util.Iterator<ds.smartwarehouse.project.orderManagement.StockReplenishResponse> replenishStock(
        ds.smartwarehouse.project.orderManagement.StockReplenishRequest request) {
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
    public com.google.common.util.concurrent.ListenableFuture<ds.smartwarehouse.project.orderManagement.StockResponse> stockCheck(
        ds.smartwarehouse.project.orderManagement.StockRequest request) {
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
          serviceImpl.stockCheck((ds.smartwarehouse.project.orderManagement.StockRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.StockResponse>) responseObserver);
          break;
        case METHODID_REPLENISH_STOCK:
          serviceImpl.replenishStock((ds.smartwarehouse.project.orderManagement.StockReplenishRequest) request,
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.StockReplenishResponse>) responseObserver);
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
              (io.grpc.stub.StreamObserver<ds.smartwarehouse.project.orderManagement.OrderTrackingResponse>) responseObserver);
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
      return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.getDescriptor();
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
