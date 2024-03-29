// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: orderManagement.proto

package ds.smartwarehouse.project.orderManagement;

/**
 * Protobuf type {@code OrderTrackingRequest}
 */
public  final class OrderTrackingRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:OrderTrackingRequest)
    OrderTrackingRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use OrderTrackingRequest.newBuilder() to construct.
  private OrderTrackingRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private OrderTrackingRequest() {
    orderNumber_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private OrderTrackingRequest(
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
    return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_OrderTrackingRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_OrderTrackingRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.class, ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.Builder.class);
  }

  public static final int ORDERNUMBER_FIELD_NUMBER = 1;
  private int orderNumber_;
  /**
   * <pre>
   *order number request
   * </pre>
   *
   * <code>int32 orderNumber = 1;</code>
   */
  public int getOrderNumber() {
    return orderNumber_;
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
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.smartwarehouse.project.orderManagement.OrderTrackingRequest)) {
      return super.equals(obj);
    }
    ds.smartwarehouse.project.orderManagement.OrderTrackingRequest other = (ds.smartwarehouse.project.orderManagement.OrderTrackingRequest) obj;

    boolean result = true;
    result = result && (getOrderNumber()
        == other.getOrderNumber());
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
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parseFrom(
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
  public static Builder newBuilder(ds.smartwarehouse.project.orderManagement.OrderTrackingRequest prototype) {
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
   * Protobuf type {@code OrderTrackingRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:OrderTrackingRequest)
      ds.smartwarehouse.project.orderManagement.OrderTrackingRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_OrderTrackingRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_OrderTrackingRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.class, ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.Builder.class);
    }

    // Construct using ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.newBuilder()
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

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_OrderTrackingRequest_descriptor;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagement.OrderTrackingRequest getDefaultInstanceForType() {
      return ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagement.OrderTrackingRequest build() {
      ds.smartwarehouse.project.orderManagement.OrderTrackingRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagement.OrderTrackingRequest buildPartial() {
      ds.smartwarehouse.project.orderManagement.OrderTrackingRequest result = new ds.smartwarehouse.project.orderManagement.OrderTrackingRequest(this);
      result.orderNumber_ = orderNumber_;
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
      if (other instanceof ds.smartwarehouse.project.orderManagement.OrderTrackingRequest) {
        return mergeFrom((ds.smartwarehouse.project.orderManagement.OrderTrackingRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.smartwarehouse.project.orderManagement.OrderTrackingRequest other) {
      if (other == ds.smartwarehouse.project.orderManagement.OrderTrackingRequest.getDefaultInstance()) return this;
      if (other.getOrderNumber() != 0) {
        setOrderNumber(other.getOrderNumber());
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
      ds.smartwarehouse.project.orderManagement.OrderTrackingRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.smartwarehouse.project.orderManagement.OrderTrackingRequest) e.getUnfinishedMessage();
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
     * <pre>
     *order number request
     * </pre>
     *
     * <code>int32 orderNumber = 1;</code>
     */
    public int getOrderNumber() {
      return orderNumber_;
    }
    /**
     * <pre>
     *order number request
     * </pre>
     *
     * <code>int32 orderNumber = 1;</code>
     */
    public Builder setOrderNumber(int value) {
      
      orderNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *order number request
     * </pre>
     *
     * <code>int32 orderNumber = 1;</code>
     */
    public Builder clearOrderNumber() {
      
      orderNumber_ = 0;
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


    // @@protoc_insertion_point(builder_scope:OrderTrackingRequest)
  }

  // @@protoc_insertion_point(class_scope:OrderTrackingRequest)
  private static final ds.smartwarehouse.project.orderManagement.OrderTrackingRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.smartwarehouse.project.orderManagement.OrderTrackingRequest();
  }

  public static ds.smartwarehouse.project.orderManagement.OrderTrackingRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<OrderTrackingRequest>
      PARSER = new com.google.protobuf.AbstractParser<OrderTrackingRequest>() {
    @java.lang.Override
    public OrderTrackingRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new OrderTrackingRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<OrderTrackingRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<OrderTrackingRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.smartwarehouse.project.orderManagement.OrderTrackingRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

