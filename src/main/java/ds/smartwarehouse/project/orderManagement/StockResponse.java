// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: orderManagement.proto

package ds.smartwarehouse.project.orderManagement;

/**
 * Protobuf type {@code StockResponse}
 */
public  final class StockResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:StockResponse)
    StockResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StockResponse.newBuilder() to construct.
  private StockResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StockResponse() {
    stockNumber_ = 0;
    stockType_ = "";
    notFoundMsg_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StockResponse(
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

            stockNumber_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            stockType_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            notFoundMsg_ = s;
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
    return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_StockResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_StockResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.smartwarehouse.project.orderManagement.StockResponse.class, ds.smartwarehouse.project.orderManagement.StockResponse.Builder.class);
  }

  public static final int STOCKNUMBER_FIELD_NUMBER = 1;
  private int stockNumber_;
  /**
   * <code>int32 stockNumber = 1;</code>
   */
  public int getStockNumber() {
    return stockNumber_;
  }

  public static final int STOCKTYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object stockType_;
  /**
   * <code>string stockType = 2;</code>
   */
  public java.lang.String getStockType() {
    java.lang.Object ref = stockType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      stockType_ = s;
      return s;
    }
  }
  /**
   * <code>string stockType = 2;</code>
   */
  public com.google.protobuf.ByteString
      getStockTypeBytes() {
    java.lang.Object ref = stockType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      stockType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NOTFOUNDMSG_FIELD_NUMBER = 3;
  private volatile java.lang.Object notFoundMsg_;
  /**
   * <code>string notFoundMsg = 3;</code>
   */
  public java.lang.String getNotFoundMsg() {
    java.lang.Object ref = notFoundMsg_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      notFoundMsg_ = s;
      return s;
    }
  }
  /**
   * <code>string notFoundMsg = 3;</code>
   */
  public com.google.protobuf.ByteString
      getNotFoundMsgBytes() {
    java.lang.Object ref = notFoundMsg_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      notFoundMsg_ = b;
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
    if (stockNumber_ != 0) {
      output.writeInt32(1, stockNumber_);
    }
    if (!getStockTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, stockType_);
    }
    if (!getNotFoundMsgBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, notFoundMsg_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (stockNumber_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, stockNumber_);
    }
    if (!getStockTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, stockType_);
    }
    if (!getNotFoundMsgBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, notFoundMsg_);
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
    if (!(obj instanceof ds.smartwarehouse.project.orderManagement.StockResponse)) {
      return super.equals(obj);
    }
    ds.smartwarehouse.project.orderManagement.StockResponse other = (ds.smartwarehouse.project.orderManagement.StockResponse) obj;

    boolean result = true;
    result = result && (getStockNumber()
        == other.getStockNumber());
    result = result && getStockType()
        .equals(other.getStockType());
    result = result && getNotFoundMsg()
        .equals(other.getNotFoundMsg());
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
    hash = (37 * hash) + STOCKNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getStockNumber();
    hash = (37 * hash) + STOCKTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getStockType().hashCode();
    hash = (37 * hash) + NOTFOUNDMSG_FIELD_NUMBER;
    hash = (53 * hash) + getNotFoundMsg().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.orderManagement.StockResponse parseFrom(
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
  public static Builder newBuilder(ds.smartwarehouse.project.orderManagement.StockResponse prototype) {
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
   * Protobuf type {@code StockResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:StockResponse)
      ds.smartwarehouse.project.orderManagement.StockResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_StockResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_StockResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.smartwarehouse.project.orderManagement.StockResponse.class, ds.smartwarehouse.project.orderManagement.StockResponse.Builder.class);
    }

    // Construct using ds.smartwarehouse.project.orderManagement.StockResponse.newBuilder()
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
      stockNumber_ = 0;

      stockType_ = "";

      notFoundMsg_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.smartwarehouse.project.orderManagement.NewOrderManagementImpl.internal_static_StockResponse_descriptor;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagement.StockResponse getDefaultInstanceForType() {
      return ds.smartwarehouse.project.orderManagement.StockResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagement.StockResponse build() {
      ds.smartwarehouse.project.orderManagement.StockResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.orderManagement.StockResponse buildPartial() {
      ds.smartwarehouse.project.orderManagement.StockResponse result = new ds.smartwarehouse.project.orderManagement.StockResponse(this);
      result.stockNumber_ = stockNumber_;
      result.stockType_ = stockType_;
      result.notFoundMsg_ = notFoundMsg_;
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
      if (other instanceof ds.smartwarehouse.project.orderManagement.StockResponse) {
        return mergeFrom((ds.smartwarehouse.project.orderManagement.StockResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.smartwarehouse.project.orderManagement.StockResponse other) {
      if (other == ds.smartwarehouse.project.orderManagement.StockResponse.getDefaultInstance()) return this;
      if (other.getStockNumber() != 0) {
        setStockNumber(other.getStockNumber());
      }
      if (!other.getStockType().isEmpty()) {
        stockType_ = other.stockType_;
        onChanged();
      }
      if (!other.getNotFoundMsg().isEmpty()) {
        notFoundMsg_ = other.notFoundMsg_;
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
      ds.smartwarehouse.project.orderManagement.StockResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.smartwarehouse.project.orderManagement.StockResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int stockNumber_ ;
    /**
     * <code>int32 stockNumber = 1;</code>
     */
    public int getStockNumber() {
      return stockNumber_;
    }
    /**
     * <code>int32 stockNumber = 1;</code>
     */
    public Builder setStockNumber(int value) {
      
      stockNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 stockNumber = 1;</code>
     */
    public Builder clearStockNumber() {
      
      stockNumber_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object stockType_ = "";
    /**
     * <code>string stockType = 2;</code>
     */
    public java.lang.String getStockType() {
      java.lang.Object ref = stockType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        stockType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string stockType = 2;</code>
     */
    public com.google.protobuf.ByteString
        getStockTypeBytes() {
      java.lang.Object ref = stockType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        stockType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string stockType = 2;</code>
     */
    public Builder setStockType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      stockType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string stockType = 2;</code>
     */
    public Builder clearStockType() {
      
      stockType_ = getDefaultInstance().getStockType();
      onChanged();
      return this;
    }
    /**
     * <code>string stockType = 2;</code>
     */
    public Builder setStockTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      stockType_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object notFoundMsg_ = "";
    /**
     * <code>string notFoundMsg = 3;</code>
     */
    public java.lang.String getNotFoundMsg() {
      java.lang.Object ref = notFoundMsg_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        notFoundMsg_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string notFoundMsg = 3;</code>
     */
    public com.google.protobuf.ByteString
        getNotFoundMsgBytes() {
      java.lang.Object ref = notFoundMsg_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        notFoundMsg_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string notFoundMsg = 3;</code>
     */
    public Builder setNotFoundMsg(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      notFoundMsg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string notFoundMsg = 3;</code>
     */
    public Builder clearNotFoundMsg() {
      
      notFoundMsg_ = getDefaultInstance().getNotFoundMsg();
      onChanged();
      return this;
    }
    /**
     * <code>string notFoundMsg = 3;</code>
     */
    public Builder setNotFoundMsgBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      notFoundMsg_ = value;
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


    // @@protoc_insertion_point(builder_scope:StockResponse)
  }

  // @@protoc_insertion_point(class_scope:StockResponse)
  private static final ds.smartwarehouse.project.orderManagement.StockResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.smartwarehouse.project.orderManagement.StockResponse();
  }

  public static ds.smartwarehouse.project.orderManagement.StockResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StockResponse>
      PARSER = new com.google.protobuf.AbstractParser<StockResponse>() {
    @java.lang.Override
    public StockResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StockResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StockResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StockResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.smartwarehouse.project.orderManagement.StockResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

