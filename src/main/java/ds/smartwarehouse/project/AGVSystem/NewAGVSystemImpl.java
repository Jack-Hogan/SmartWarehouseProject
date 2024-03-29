// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AGVSystem.proto

package ds.smartwarehouse.project.AGVSystem;

public final class NewAGVSystemImpl {
  private NewAGVSystemImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VehicleTrackingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VehicleTrackingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_VehicleTrackingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_VehicleTrackingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AGVProductivityRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AGVProductivityRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AGVProductivityResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AGVProductivityResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AGVDiagRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AGVDiagRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AGVDiagResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AGVDiagResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017AGVSystem.proto\")\n\026VehicleTrackingRequ" +
      "est\022\017\n\007AGVtype\030\001 \001(\t\"U\n\027VehicleTrackingR" +
      "esponse\022\017\n\007AGVtype\030\001 \001(\t\022\023\n\013AGVlatitude\030" +
      "\002 \001(\001\022\024\n\014AGVlongitude\030\003 \001(\001\"+\n\026AGVProduc" +
      "tivityRequest\022\021\n\tAGVreport\030\001 \001(\t\"j\n\027AGVP" +
      "roductivityResponse\022\026\n\016AGVreportReply\030\001 " +
      "\001(\t\022\r\n\005stock\030\002 \001(\t\022\023\n\013performance\030\003 \001(\t\022" +
      "\023\n\013maintenance\030\004 \001(\t\">\n\016AGVDiagRequest\022\026" +
      "\n\016AGVdiagRequest\030\001 \001(\t\022\024\n\014AGVfrequency\030\002" +
      " \001(\005\"A\n\017AGVDiagResponse\022\023\n\013AGVdiagType\030\001" +
      " \001(\t\022\031\n\021systemPerformance\030\002 \001(\0052\321\001\n\tAGVS" +
      "ystem\022J\n\017vehicleTracking\022\027.VehicleTracki" +
      "ngRequest\032\030.VehicleTrackingResponse\"\000(\0010" +
      "\001\022F\n\017agvProductivity\022\027.AGVProductivityRe" +
      "quest\032\030.AGVProductivityResponse\"\000\0220\n\007agv" +
      "Diag\022\017.AGVDiagRequest\032\020.AGVDiagResponse\"" +
      "\0000\001B9\n#ds.smartwarehouse.project.AGVSyst" +
      "emB\020NewAGVSystemImplP\001b\006proto3"
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
    internal_static_VehicleTrackingRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_VehicleTrackingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VehicleTrackingRequest_descriptor,
        new java.lang.String[] { "AGVtype", });
    internal_static_VehicleTrackingResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_VehicleTrackingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_VehicleTrackingResponse_descriptor,
        new java.lang.String[] { "AGVtype", "AGVlatitude", "AGVlongitude", });
    internal_static_AGVProductivityRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_AGVProductivityRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AGVProductivityRequest_descriptor,
        new java.lang.String[] { "AGVreport", });
    internal_static_AGVProductivityResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_AGVProductivityResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AGVProductivityResponse_descriptor,
        new java.lang.String[] { "AGVreportReply", "Stock", "Performance", "Maintenance", });
    internal_static_AGVDiagRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_AGVDiagRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AGVDiagRequest_descriptor,
        new java.lang.String[] { "AGVdiagRequest", "AGVfrequency", });
    internal_static_AGVDiagResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_AGVDiagResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AGVDiagResponse_descriptor,
        new java.lang.String[] { "AGVdiagType", "SystemPerformance", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
