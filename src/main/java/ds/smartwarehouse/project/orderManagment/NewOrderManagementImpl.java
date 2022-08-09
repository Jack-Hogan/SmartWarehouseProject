// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: orderManagement.proto

package ds.smartwarehouse.project.orderManagment;

public final class NewOrderManagementImpl {
  private NewOrderManagementImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StockRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StockRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StockResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StockResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StockReplenishRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StockReplenishRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_StockReplenishResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_StockReplenishResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OrderTrackingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OrderTrackingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OrderTrackingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OrderTrackingResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025orderManagement.proto\"$\n\014StockRequest\022" +
      "\024\n\014stockMessage\030\001 \001(\t\"7\n\rStockResponse\022\023" +
      "\n\013stockNumber\030\001 \001(\005\022\021\n\tstockType\030\002 \001(\t\"1" +
      "\n\025StockReplenishRequest\022\030\n\020replenishMess" +
      "age\030\001 \001(\t\"n\n\026StockReplenishResponse\022\025\n\rr" +
      "eplenishType\030\001 \001(\t\022\020\n\010lowStock\030\002 \001(\005\022\021\n\t" +
      "highStock\030\003 \001(\005\022\030\n\020stockReplenished\030\004 \001(" +
      "\t\"+\n\024OrderTrackingRequest\022\023\n\013orderNumber" +
      "\030\001 \001(\005\"A\n\025OrderTrackingResponse\022\023\n\013order" +
      "Number\030\001 \001(\005\022\023\n\013orderStatus\030\002 \001(\t2\313\001\n\017Or" +
      "derManagement\022-\n\nstockCheck\022\r.StockReque" +
      "st\032\016.StockResponse\"\000\022E\n\016replenishStock\022\026" +
      ".StockReplenishRequest\032\027.StockReplenishR" +
      "esponse\"\0000\001\022B\n\rorderTracking\022\025.OrderTrac" +
      "kingRequest\032\026.OrderTrackingResponse\"\000(\001B" +
      "D\n(ds.smartwarehouse.project.orderManagm" +
      "entB\026NewOrderManagementImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_StockRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_StockRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StockRequest_descriptor,
        new java.lang.String[] { "StockMessage", });
    internal_static_StockResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_StockResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StockResponse_descriptor,
        new java.lang.String[] { "StockNumber", "StockType", });
    internal_static_StockReplenishRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_StockReplenishRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StockReplenishRequest_descriptor,
        new java.lang.String[] { "ReplenishMessage", });
    internal_static_StockReplenishResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_StockReplenishResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_StockReplenishResponse_descriptor,
        new java.lang.String[] { "ReplenishType", "LowStock", "HighStock", "StockReplenished", });
    internal_static_OrderTrackingRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_OrderTrackingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OrderTrackingRequest_descriptor,
        new java.lang.String[] { "OrderNumber", });
    internal_static_OrderTrackingResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_OrderTrackingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OrderTrackingResponse_descriptor,
        new java.lang.String[] { "OrderNumber", "OrderStatus", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}