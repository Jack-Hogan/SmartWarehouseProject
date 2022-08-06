// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: orderManagement.proto

package ds.smartwarehouse.project.orderManagment;

/**
 * Protobuf type {@code OrderTrackingResponse}
 */
public  final class OrderTrackingResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:OrderTrackingResponse)
    OrderTrackingResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OrderTrackingResponse.newBuilder() to construct.
  private OrderTrackingResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OrderTrackingResponse() {
    orderNumber_ = 0;
    orderStatus_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OrderTrackingResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            orderNumber_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            orderStatus_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.smartwarehouse.project.orderManagment.NewOrderManagementImpl.internal_static_OrderTrackingResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.smartwarehouse.project.orderManagment.NewOrderManagementImpl.internal_static_OrderTrackingResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.class, ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.Builder.class);
  }

  public static final int ORDERNUMBER_FIELD_NUMBER = 1;
  private int orderNumber_;
  /**
   * <code>int32 orderNumber = 1;</code>
   */
  public int getOrderNumber() {
    return orderNumber_;
  }

  public static final int ORDERSTATUS_FIELD_NUMBER = 2;
  private volatile java.lang.Object orderStatus_;
  /**
   * <code>string orderStatus = 2;</code>
   */
  public java.lang.String getOrderStatus() {
    java.lang.Object ref = orderStatus_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      orderStatus_ = s;
      return s;
    }
  }
  /**
   * <code>string orderStatus = 2;</code>
   */
  public com.google.protobuf.ByteString
      getOrderStatusBytes() {
    java.lang.Object ref = orderStatus_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      orderStatus_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (orderNumber_ != 0) {
      output.writeInt32(1, orderNumber_);
    }
    if (!getOrderStatusBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, orderStatus_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (orderNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, orderNumber_);
    }
    if (!getOrderStatusBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, orderStatus_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.smartwarehouse.project.orderManagment.OrderTrackingResponse)) {
      return super.equals(obj);
    }
    ds.smartwarehouse.project.orderManagment.OrderTrackingResponse other = (ds.smartwarehouse.project.orderManagment.OrderTrackingResponse) obj;

    boolean result = true;
    result = result && (getOrderNumber()
        == other.getOrderNumber());
    result = result && getOrderStatus()
        .equals(other.getOrderStatus());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ORDERNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getOrderNumber();
    hash = (37 * hash) + ORDERSTATUS_FIELD_NUMBER;
    hash = (53 * hash) + getOrderStatus().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.smartwarehouse.project.orderManagment.OrderTrackingResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code OrderTrackingResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:OrderTrackingResponse)
      ds.smartwarehouse.project.orderManagment.OrderTrackingResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.smartwarehouse.project.orderManagment.NewOrderManagementImpl.internal_static_OrderTrackingResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.smartwarehouse.project.orderManagment.NewOrderManagementImpl.internal_static_OrderTrackingResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.class, ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.Builder.class);
    }

    // Construct using ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      orderNumber_ = 0;

      orderStatus_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.smartwarehouse.project.orderManagment.NewOrderManagementImpl.internal_static_OrderTrackingResponse_descriptor;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagment.OrderTrackingResponse getDefaultInstanceForType() {
      return ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagment.OrderTrackingResponse build() {
      ds.smartwarehouse.project.orderManagment.OrderTrackingResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagment.OrderTrackingResponse buildPartial() {
      ds.smartwarehouse.project.orderManagment.OrderTrackingResponse result = new ds.smartwarehouse.project.orderManagment.OrderTrackingResponse(this);
      result.orderNumber_ = orderNumber_;
      result.orderStatus_ = orderStatus_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.smartwarehouse.project.orderManagment.OrderTrackingResponse) {
        return mergeFrom((ds.smartwarehouse.project.orderManagment.OrderTrackingResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.smartwarehouse.project.orderManagment.OrderTrackingResponse other) {
      if (other == ds.smartwarehouse.project.orderManagment.OrderTrackingResponse.getDefaultInstance()) return this;
      if (other.getOrderNumber() != 0) {
        setOrderNumber(other.getOrderNumber());
      }
      if (!other.getOrderStatus().isEmpty()) {
        orderStatus_ = other.orderStatus_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.smartwarehouse.project.orderManagment.OrderTrackingResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.smartwarehouse.project.orderManagment.OrderTrackingResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int orderNumber_ ;
    /**
     * <code>int32 orderNumber = 1;</code>
     */
    public int getOrderNumber() {
      return orderNumber_;
    }
    /**
     * <code>int32 orderNumber = 1;</code>
     */
    public Builder setOrderNumber(int value) {
      
      orderNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 orderNumber = 1;</code>
     */
    public Builder clearOrderNumber() {
      
      orderNumber_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object orderStatus_ = "";
    /**
     * <code>string orderStatus = 2;</code>
     */
    public java.lang.String getOrderStatus() {
      java.lang.Object ref = orderStatus_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        orderStatus_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string orderStatus = 2;</code>
     */
    public com.google.protobuf.ByteString
        getOrderStatusBytes() {
      java.lang.Object ref = orderStatus_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        orderStatus_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string orderStatus = 2;</code>
     */
    public Builder setOrderStatus(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      orderStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string orderStatus = 2;</code>
     */
    public Builder clearOrderStatus() {
      
      orderStatus_ = getDefaultInstance().getOrderStatus();
      onChanged();
      return this;
    }
    /**
     * <code>string orderStatus = 2;</code>
     */
    public Builder setOrderStatusBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      orderStatus_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:OrderTrackingResponse)
  }

  // @@protoc_insertion_point(class_scope:OrderTrackingResponse)
  private static final ds.smartwarehouse.project.orderManagment.OrderTrackingResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.smartwarehouse.project.orderManagment.OrderTrackingResponse();
  }

  public static ds.smartwarehouse.project.orderManagment.OrderTrackingResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OrderTrackingResponse>
      PARSER = new com.google.protobuf.AbstractParser<OrderTrackingResponse>() {
    @java.lang.Override
    public OrderTrackingResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OrderTrackingResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OrderTrackingResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OrderTrackingResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.smartwarehouse.project.orderManagment.OrderTrackingResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

