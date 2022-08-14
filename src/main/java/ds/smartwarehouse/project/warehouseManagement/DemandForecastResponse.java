// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: warehouseManagement.proto

package ds.smartwarehouse.project.warehouseManagement;

/**
 * Protobuf type {@code DemandForecastResponse}
 */
public  final class DemandForecastResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:DemandForecastResponse)
    DemandForecastResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DemandForecastResponse.newBuilder() to construct.
  private DemandForecastResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DemandForecastResponse() {
    forecastReview_ = "";
    highDemand_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DemandForecastResponse(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            forecastReview_ = s;
            break;
          }
          case 16: {

            highDemand_ = input.readInt32();
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
    return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_DemandForecastResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_DemandForecastResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse.class, ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse.Builder.class);
  }

  public static final int FORECASTREVIEW_FIELD_NUMBER = 1;
  private volatile java.lang.Object forecastReview_;
  /**
   * <pre>
   *review in demand
   * </pre>
   *
   * <code>string forecastReview = 1;</code>
   */
  public java.lang.String getForecastReview() {
    java.lang.Object ref = forecastReview_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      forecastReview_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *review in demand
   * </pre>
   *
   * <code>string forecastReview = 1;</code>
   */
  public com.google.protobuf.ByteString
      getForecastReviewBytes() {
    java.lang.Object ref = forecastReview_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      forecastReview_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HIGHDEMAND_FIELD_NUMBER = 2;
  private int highDemand_;
  /**
   * <pre>
   *what item is in demand
   * </pre>
   *
   * <code>int32 highDemand = 2;</code>
   */
  public int getHighDemand() {
    return highDemand_;
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
    if (!getForecastReviewBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, forecastReview_);
    }
    if (highDemand_ != 0) {
      output.writeInt32(2, highDemand_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getForecastReviewBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, forecastReview_);
    }
    if (highDemand_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, highDemand_);
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
    if (!(obj instanceof ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse)) {
      return super.equals(obj);
    }
    ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse other = (ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse) obj;

    boolean result = true;
    result = result && getForecastReview()
        .equals(other.getForecastReview());
    result = result && (getHighDemand()
        == other.getHighDemand());
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
    hash = (37 * hash) + FORECASTREVIEW_FIELD_NUMBER;
    hash = (53 * hash) + getForecastReview().hashCode();
    hash = (37 * hash) + HIGHDEMAND_FIELD_NUMBER;
    hash = (53 * hash) + getHighDemand();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parseFrom(
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
  public static Builder newBuilder(ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse prototype) {
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
   * Protobuf type {@code DemandForecastResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:DemandForecastResponse)
      ds.smartwarehouse.project.warehouseManagement.DemandForecastResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_DemandForecastResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_DemandForecastResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse.class, ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse.Builder.class);
    }

    // Construct using ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse.newBuilder()
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
      forecastReview_ = "";

      highDemand_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_DemandForecastResponse_descriptor;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse getDefaultInstanceForType() {
      return ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse build() {
      ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse buildPartial() {
      ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse result = new ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse(this);
      result.forecastReview_ = forecastReview_;
      result.highDemand_ = highDemand_;
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
      if (other instanceof ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse) {
        return mergeFrom((ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse other) {
      if (other == ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse.getDefaultInstance()) return this;
      if (!other.getForecastReview().isEmpty()) {
        forecastReview_ = other.forecastReview_;
        onChanged();
      }
      if (other.getHighDemand() != 0) {
        setHighDemand(other.getHighDemand());
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
      ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object forecastReview_ = "";
    /**
     * <pre>
     *review in demand
     * </pre>
     *
     * <code>string forecastReview = 1;</code>
     */
    public java.lang.String getForecastReview() {
      java.lang.Object ref = forecastReview_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        forecastReview_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *review in demand
     * </pre>
     *
     * <code>string forecastReview = 1;</code>
     */
    public com.google.protobuf.ByteString
        getForecastReviewBytes() {
      java.lang.Object ref = forecastReview_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        forecastReview_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *review in demand
     * </pre>
     *
     * <code>string forecastReview = 1;</code>
     */
    public Builder setForecastReview(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      forecastReview_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *review in demand
     * </pre>
     *
     * <code>string forecastReview = 1;</code>
     */
    public Builder clearForecastReview() {
      
      forecastReview_ = getDefaultInstance().getForecastReview();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *review in demand
     * </pre>
     *
     * <code>string forecastReview = 1;</code>
     */
    public Builder setForecastReviewBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      forecastReview_ = value;
      onChanged();
      return this;
    }

    private int highDemand_ ;
    /**
     * <pre>
     *what item is in demand
     * </pre>
     *
     * <code>int32 highDemand = 2;</code>
     */
    public int getHighDemand() {
      return highDemand_;
    }
    /**
     * <pre>
     *what item is in demand
     * </pre>
     *
     * <code>int32 highDemand = 2;</code>
     */
    public Builder setHighDemand(int value) {
      
      highDemand_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *what item is in demand
     * </pre>
     *
     * <code>int32 highDemand = 2;</code>
     */
    public Builder clearHighDemand() {
      
      highDemand_ = 0;
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


    // @@protoc_insertion_point(builder_scope:DemandForecastResponse)
  }

  // @@protoc_insertion_point(class_scope:DemandForecastResponse)
  private static final ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse();
  }

  public static ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DemandForecastResponse>
      PARSER = new com.google.protobuf.AbstractParser<DemandForecastResponse>() {
    @java.lang.Override
    public DemandForecastResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DemandForecastResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DemandForecastResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DemandForecastResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.smartwarehouse.project.warehouseManagement.DemandForecastResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

