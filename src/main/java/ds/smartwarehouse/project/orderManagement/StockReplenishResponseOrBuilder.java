// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: orderManagement.proto

package ds.smartwarehouse.project.orderManagement;

public interface StockReplenishResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:StockReplenishResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string replenishType = 1;</code>
   */
  java.lang.String getReplenishType();
  /**
   * <code>string replenishType = 1;</code>
   */
  com.google.protobuf.ByteString
      getReplenishTypeBytes();

  /**
   * <code>int32 lowStock = 2;</code>
   */
  int getLowStock();

  /**
   * <code>int32 highStock = 3;</code>
   */
  int getHighStock();

  /**
   * <code>bool stockReplenished = 4;</code>
   */
  boolean getStockReplenished();
}
