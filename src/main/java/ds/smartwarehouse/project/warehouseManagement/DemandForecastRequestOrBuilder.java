// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: warehouseManagement.proto

package ds.smartwarehouse.project.warehouseManagement;

public interface DemandForecastRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:DemandForecastRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *forecast request
   * </pre>
   *
   * <code>string forecastMessage = 1;</code>
   */
  java.lang.String getForecastMessage();
  /**
   * <pre>
   *forecast request
   * </pre>
   *
   * <code>string forecastMessage = 1;</code>
   */
  com.google.protobuf.ByteString
      getForecastMessageBytes();

  /**
   * <pre>
   *items sold
   * </pre>
   *
   * <code>int32 itemsSold = 2;</code>
   */
  int getItemsSold();
}
