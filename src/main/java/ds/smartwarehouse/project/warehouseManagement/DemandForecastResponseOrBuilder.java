// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: warehouseManagement.proto

package ds.smartwarehouse.project.warehouseManagement;

public interface DemandForecastResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:DemandForecastResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *review in demand
   * </pre>
   *
   * <code>string forecastReview = 1;</code>
   */
  java.lang.String getForecastReview();
  /**
   * <pre>
   *review in demand
   * </pre>
   *
   * <code>string forecastReview = 1;</code>
   */
  com.google.protobuf.ByteString
      getForecastReviewBytes();

  /**
   * <pre>
   *what item is in demand
   * </pre>
   *
   * <code>int32 highDemand = 2;</code>
   */
  int getHighDemand();
}
