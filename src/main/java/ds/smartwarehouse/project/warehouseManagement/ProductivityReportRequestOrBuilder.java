// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: warehouseManagement.proto

package ds.smartwarehouse.project.warehouseManagement;

public interface ProductivityReportRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ProductivityReportRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   *report request
   * </pre>
   *
   * <code>string prodReport = 1;</code>
   */
  java.lang.String getProdReport();
  /**
   * <pre>
   *report request
   * </pre>
   *
   * <code>string prodReport = 1;</code>
   */
  com.google.protobuf.ByteString
      getProdReportBytes();

  /**
   * <pre>
   *Q1 earnings
   * </pre>
   *
   * <code>double Q1earning = 2;</code>
   */
  double getQ1Earning();

  /**
   * <pre>
   *Q2
   * </pre>
   *
   * <code>double Q2earning = 3;</code>
   */
  double getQ2Earning();

  /**
   * <pre>
   *Q3
   * </pre>
   *
   * <code>double Q3earning = 4;</code>
   */
  double getQ3Earning();

  /**
   * <pre>
   *Q4
   * </pre>
   *
   * <code>double Q4earning = 5;</code>
   */
  double getQ4Earning();
}
