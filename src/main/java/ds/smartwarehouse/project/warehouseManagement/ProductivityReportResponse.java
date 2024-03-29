// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: warehouseManagement.proto

package ds.smartwarehouse.project.warehouseManagement;

/**
 * Protobuf type {@code ProductivityReportResponse}
 */
public  final class ProductivityReportResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ProductivityReportResponse)
    ProductivityReportResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ProductivityReportResponse.newBuilder() to construct.
  private ProductivityReportResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ProductivityReportResponse() {
    prodReportService_ = "";
    aGVperformance_ = 0;
    employeeCount_ = 0;
    q1Earning_ = 0D;
    q2Earning_ = 0D;
    q3Earning_ = 0D;
    q4Earning_ = 0D;
    quartAvg_ = 0D;
    annualAvgEarning_ = 0D;
    totalEarning_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ProductivityReportResponse(
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

            prodReportService_ = s;
            break;
          }
          case 16: {

            aGVperformance_ = input.readInt32();
            break;
          }
          case 24: {

            employeeCount_ = input.readInt32();
            break;
          }
          case 33: {

            q1Earning_ = input.readDouble();
            break;
          }
          case 41: {

            q2Earning_ = input.readDouble();
            break;
          }
          case 49: {

            q3Earning_ = input.readDouble();
            break;
          }
          case 57: {

            q4Earning_ = input.readDouble();
            break;
          }
          case 65: {

            quartAvg_ = input.readDouble();
            break;
          }
          case 73: {

            annualAvgEarning_ = input.readDouble();
            break;
          }
          case 81: {

            totalEarning_ = input.readDouble();
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
    return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_ProductivityReportResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_ProductivityReportResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse.class, ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse.Builder.class);
  }

  public static final int PRODREPORTSERVICE_FIELD_NUMBER = 1;
  private volatile java.lang.Object prodReportService_;
  /**
   * <pre>
   *Report service response
   * </pre>
   *
   * <code>string prodReportService = 1;</code>
   */
  public java.lang.String getProdReportService() {
    java.lang.Object ref = prodReportService_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      prodReportService_ = s;
      return s;
    }
  }
  /**
   * <pre>
   *Report service response
   * </pre>
   *
   * <code>string prodReportService = 1;</code>
   */
  public com.google.protobuf.ByteString
      getProdReportServiceBytes() {
    java.lang.Object ref = prodReportService_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      prodReportService_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AGVPERFORMANCE_FIELD_NUMBER = 2;
  private int aGVperformance_;
  /**
   * <pre>
   *vehicle performance
   * </pre>
   *
   * <code>int32 AGVperformance = 2;</code>
   */
  public int getAGVperformance() {
    return aGVperformance_;
  }

  public static final int EMPLOYEECOUNT_FIELD_NUMBER = 3;
  private int employeeCount_;
  /**
   * <pre>
   *head count on employees
   * </pre>
   *
   * <code>int32 EmployeeCount = 3;</code>
   */
  public int getEmployeeCount() {
    return employeeCount_;
  }

  public static final int Q1EARNING_FIELD_NUMBER = 4;
  private double q1Earning_;
  /**
   * <pre>
   *Q1 earnings
   * </pre>
   *
   * <code>double Q1earning = 4;</code>
   */
  public double getQ1Earning() {
    return q1Earning_;
  }

  public static final int Q2EARNING_FIELD_NUMBER = 5;
  private double q2Earning_;
  /**
   * <pre>
   *Q2
   * </pre>
   *
   * <code>double Q2earning = 5;</code>
   */
  public double getQ2Earning() {
    return q2Earning_;
  }

  public static final int Q3EARNING_FIELD_NUMBER = 6;
  private double q3Earning_;
  /**
   * <pre>
   *Q3
   * </pre>
   *
   * <code>double Q3earning = 6;</code>
   */
  public double getQ3Earning() {
    return q3Earning_;
  }

  public static final int Q4EARNING_FIELD_NUMBER = 7;
  private double q4Earning_;
  /**
   * <pre>
   *Q4
   * </pre>
   *
   * <code>double Q4earning = 7;</code>
   */
  public double getQ4Earning() {
    return q4Earning_;
  }

  public static final int QUARTAVG_FIELD_NUMBER = 8;
  private double quartAvg_;
  /**
   * <pre>
   *Quarterly Average
   * </pre>
   *
   * <code>double QuartAvg = 8;</code>
   */
  public double getQuartAvg() {
    return quartAvg_;
  }

  public static final int ANNUALAVGEARNING_FIELD_NUMBER = 9;
  private double annualAvgEarning_;
  /**
   * <pre>
   *Average yearly earning
   * </pre>
   *
   * <code>double AnnualAvgEarning = 9;</code>
   */
  public double getAnnualAvgEarning() {
    return annualAvgEarning_;
  }

  public static final int TOTALEARNING_FIELD_NUMBER = 10;
  private double totalEarning_;
  /**
   * <pre>
   *total earning
   * </pre>
   *
   * <code>double totalEarning = 10;</code>
   */
  public double getTotalEarning() {
    return totalEarning_;
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
    if (!getProdReportServiceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, prodReportService_);
    }
    if (aGVperformance_ != 0) {
      output.writeInt32(2, aGVperformance_);
    }
    if (employeeCount_ != 0) {
      output.writeInt32(3, employeeCount_);
    }
    if (q1Earning_ != 0D) {
      output.writeDouble(4, q1Earning_);
    }
    if (q2Earning_ != 0D) {
      output.writeDouble(5, q2Earning_);
    }
    if (q3Earning_ != 0D) {
      output.writeDouble(6, q3Earning_);
    }
    if (q4Earning_ != 0D) {
      output.writeDouble(7, q4Earning_);
    }
    if (quartAvg_ != 0D) {
      output.writeDouble(8, quartAvg_);
    }
    if (annualAvgEarning_ != 0D) {
      output.writeDouble(9, annualAvgEarning_);
    }
    if (totalEarning_ != 0D) {
      output.writeDouble(10, totalEarning_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getProdReportServiceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, prodReportService_);
    }
    if (aGVperformance_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, aGVperformance_);
    }
    if (employeeCount_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, employeeCount_);
    }
    if (q1Earning_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(4, q1Earning_);
    }
    if (q2Earning_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(5, q2Earning_);
    }
    if (q3Earning_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(6, q3Earning_);
    }
    if (q4Earning_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(7, q4Earning_);
    }
    if (quartAvg_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(8, quartAvg_);
    }
    if (annualAvgEarning_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(9, annualAvgEarning_);
    }
    if (totalEarning_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(10, totalEarning_);
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
    if (!(obj instanceof ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse)) {
      return super.equals(obj);
    }
    ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse other = (ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse) obj;

    boolean result = true;
    result = result && getProdReportService()
        .equals(other.getProdReportService());
    result = result && (getAGVperformance()
        == other.getAGVperformance());
    result = result && (getEmployeeCount()
        == other.getEmployeeCount());
    result = result && (
        java.lang.Double.doubleToLongBits(getQ1Earning())
        == java.lang.Double.doubleToLongBits(
            other.getQ1Earning()));
    result = result && (
        java.lang.Double.doubleToLongBits(getQ2Earning())
        == java.lang.Double.doubleToLongBits(
            other.getQ2Earning()));
    result = result && (
        java.lang.Double.doubleToLongBits(getQ3Earning())
        == java.lang.Double.doubleToLongBits(
            other.getQ3Earning()));
    result = result && (
        java.lang.Double.doubleToLongBits(getQ4Earning())
        == java.lang.Double.doubleToLongBits(
            other.getQ4Earning()));
    result = result && (
        java.lang.Double.doubleToLongBits(getQuartAvg())
        == java.lang.Double.doubleToLongBits(
            other.getQuartAvg()));
    result = result && (
        java.lang.Double.doubleToLongBits(getAnnualAvgEarning())
        == java.lang.Double.doubleToLongBits(
            other.getAnnualAvgEarning()));
    result = result && (
        java.lang.Double.doubleToLongBits(getTotalEarning())
        == java.lang.Double.doubleToLongBits(
            other.getTotalEarning()));
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
    hash = (37 * hash) + PRODREPORTSERVICE_FIELD_NUMBER;
    hash = (53 * hash) + getProdReportService().hashCode();
    hash = (37 * hash) + AGVPERFORMANCE_FIELD_NUMBER;
    hash = (53 * hash) + getAGVperformance();
    hash = (37 * hash) + EMPLOYEECOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getEmployeeCount();
    hash = (37 * hash) + Q1EARNING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getQ1Earning()));
    hash = (37 * hash) + Q2EARNING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getQ2Earning()));
    hash = (37 * hash) + Q3EARNING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getQ3Earning()));
    hash = (37 * hash) + Q4EARNING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getQ4Earning()));
    hash = (37 * hash) + QUARTAVG_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getQuartAvg()));
    hash = (37 * hash) + ANNUALAVGEARNING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getAnnualAvgEarning()));
    hash = (37 * hash) + TOTALEARNING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getTotalEarning()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parseFrom(
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
  public static Builder newBuilder(ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse prototype) {
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
   * Protobuf type {@code ProductivityReportResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ProductivityReportResponse)
      ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_ProductivityReportResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_ProductivityReportResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse.class, ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse.Builder.class);
    }

    // Construct using ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse.newBuilder()
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
      prodReportService_ = "";

      aGVperformance_ = 0;

      employeeCount_ = 0;

      q1Earning_ = 0D;

      q2Earning_ = 0D;

      q3Earning_ = 0D;

      q4Earning_ = 0D;

      quartAvg_ = 0D;

      annualAvgEarning_ = 0D;

      totalEarning_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.smartwarehouse.project.warehouseManagement.NewWarehouseManagementImpl.internal_static_ProductivityReportResponse_descriptor;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse getDefaultInstanceForType() {
      return ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse build() {
      ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse buildPartial() {
      ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse result = new ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse(this);
      result.prodReportService_ = prodReportService_;
      result.aGVperformance_ = aGVperformance_;
      result.employeeCount_ = employeeCount_;
      result.q1Earning_ = q1Earning_;
      result.q2Earning_ = q2Earning_;
      result.q3Earning_ = q3Earning_;
      result.q4Earning_ = q4Earning_;
      result.quartAvg_ = quartAvg_;
      result.annualAvgEarning_ = annualAvgEarning_;
      result.totalEarning_ = totalEarning_;
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
      if (other instanceof ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse) {
        return mergeFrom((ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse other) {
      if (other == ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse.getDefaultInstance()) return this;
      if (!other.getProdReportService().isEmpty()) {
        prodReportService_ = other.prodReportService_;
        onChanged();
      }
      if (other.getAGVperformance() != 0) {
        setAGVperformance(other.getAGVperformance());
      }
      if (other.getEmployeeCount() != 0) {
        setEmployeeCount(other.getEmployeeCount());
      }
      if (other.getQ1Earning() != 0D) {
        setQ1Earning(other.getQ1Earning());
      }
      if (other.getQ2Earning() != 0D) {
        setQ2Earning(other.getQ2Earning());
      }
      if (other.getQ3Earning() != 0D) {
        setQ3Earning(other.getQ3Earning());
      }
      if (other.getQ4Earning() != 0D) {
        setQ4Earning(other.getQ4Earning());
      }
      if (other.getQuartAvg() != 0D) {
        setQuartAvg(other.getQuartAvg());
      }
      if (other.getAnnualAvgEarning() != 0D) {
        setAnnualAvgEarning(other.getAnnualAvgEarning());
      }
      if (other.getTotalEarning() != 0D) {
        setTotalEarning(other.getTotalEarning());
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
      ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object prodReportService_ = "";
    /**
     * <pre>
     *Report service response
     * </pre>
     *
     * <code>string prodReportService = 1;</code>
     */
    public java.lang.String getProdReportService() {
      java.lang.Object ref = prodReportService_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        prodReportService_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     *Report service response
     * </pre>
     *
     * <code>string prodReportService = 1;</code>
     */
    public com.google.protobuf.ByteString
        getProdReportServiceBytes() {
      java.lang.Object ref = prodReportService_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        prodReportService_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     *Report service response
     * </pre>
     *
     * <code>string prodReportService = 1;</code>
     */
    public Builder setProdReportService(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      prodReportService_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Report service response
     * </pre>
     *
     * <code>string prodReportService = 1;</code>
     */
    public Builder clearProdReportService() {
      
      prodReportService_ = getDefaultInstance().getProdReportService();
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Report service response
     * </pre>
     *
     * <code>string prodReportService = 1;</code>
     */
    public Builder setProdReportServiceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      prodReportService_ = value;
      onChanged();
      return this;
    }

    private int aGVperformance_ ;
    /**
     * <pre>
     *vehicle performance
     * </pre>
     *
     * <code>int32 AGVperformance = 2;</code>
     */
    public int getAGVperformance() {
      return aGVperformance_;
    }
    /**
     * <pre>
     *vehicle performance
     * </pre>
     *
     * <code>int32 AGVperformance = 2;</code>
     */
    public Builder setAGVperformance(int value) {
      
      aGVperformance_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *vehicle performance
     * </pre>
     *
     * <code>int32 AGVperformance = 2;</code>
     */
    public Builder clearAGVperformance() {
      
      aGVperformance_ = 0;
      onChanged();
      return this;
    }

    private int employeeCount_ ;
    /**
     * <pre>
     *head count on employees
     * </pre>
     *
     * <code>int32 EmployeeCount = 3;</code>
     */
    public int getEmployeeCount() {
      return employeeCount_;
    }
    /**
     * <pre>
     *head count on employees
     * </pre>
     *
     * <code>int32 EmployeeCount = 3;</code>
     */
    public Builder setEmployeeCount(int value) {
      
      employeeCount_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *head count on employees
     * </pre>
     *
     * <code>int32 EmployeeCount = 3;</code>
     */
    public Builder clearEmployeeCount() {
      
      employeeCount_ = 0;
      onChanged();
      return this;
    }

    private double q1Earning_ ;
    /**
     * <pre>
     *Q1 earnings
     * </pre>
     *
     * <code>double Q1earning = 4;</code>
     */
    public double getQ1Earning() {
      return q1Earning_;
    }
    /**
     * <pre>
     *Q1 earnings
     * </pre>
     *
     * <code>double Q1earning = 4;</code>
     */
    public Builder setQ1Earning(double value) {
      
      q1Earning_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Q1 earnings
     * </pre>
     *
     * <code>double Q1earning = 4;</code>
     */
    public Builder clearQ1Earning() {
      
      q1Earning_ = 0D;
      onChanged();
      return this;
    }

    private double q2Earning_ ;
    /**
     * <pre>
     *Q2
     * </pre>
     *
     * <code>double Q2earning = 5;</code>
     */
    public double getQ2Earning() {
      return q2Earning_;
    }
    /**
     * <pre>
     *Q2
     * </pre>
     *
     * <code>double Q2earning = 5;</code>
     */
    public Builder setQ2Earning(double value) {
      
      q2Earning_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Q2
     * </pre>
     *
     * <code>double Q2earning = 5;</code>
     */
    public Builder clearQ2Earning() {
      
      q2Earning_ = 0D;
      onChanged();
      return this;
    }

    private double q3Earning_ ;
    /**
     * <pre>
     *Q3
     * </pre>
     *
     * <code>double Q3earning = 6;</code>
     */
    public double getQ3Earning() {
      return q3Earning_;
    }
    /**
     * <pre>
     *Q3
     * </pre>
     *
     * <code>double Q3earning = 6;</code>
     */
    public Builder setQ3Earning(double value) {
      
      q3Earning_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Q3
     * </pre>
     *
     * <code>double Q3earning = 6;</code>
     */
    public Builder clearQ3Earning() {
      
      q3Earning_ = 0D;
      onChanged();
      return this;
    }

    private double q4Earning_ ;
    /**
     * <pre>
     *Q4
     * </pre>
     *
     * <code>double Q4earning = 7;</code>
     */
    public double getQ4Earning() {
      return q4Earning_;
    }
    /**
     * <pre>
     *Q4
     * </pre>
     *
     * <code>double Q4earning = 7;</code>
     */
    public Builder setQ4Earning(double value) {
      
      q4Earning_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Q4
     * </pre>
     *
     * <code>double Q4earning = 7;</code>
     */
    public Builder clearQ4Earning() {
      
      q4Earning_ = 0D;
      onChanged();
      return this;
    }

    private double quartAvg_ ;
    /**
     * <pre>
     *Quarterly Average
     * </pre>
     *
     * <code>double QuartAvg = 8;</code>
     */
    public double getQuartAvg() {
      return quartAvg_;
    }
    /**
     * <pre>
     *Quarterly Average
     * </pre>
     *
     * <code>double QuartAvg = 8;</code>
     */
    public Builder setQuartAvg(double value) {
      
      quartAvg_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Quarterly Average
     * </pre>
     *
     * <code>double QuartAvg = 8;</code>
     */
    public Builder clearQuartAvg() {
      
      quartAvg_ = 0D;
      onChanged();
      return this;
    }

    private double annualAvgEarning_ ;
    /**
     * <pre>
     *Average yearly earning
     * </pre>
     *
     * <code>double AnnualAvgEarning = 9;</code>
     */
    public double getAnnualAvgEarning() {
      return annualAvgEarning_;
    }
    /**
     * <pre>
     *Average yearly earning
     * </pre>
     *
     * <code>double AnnualAvgEarning = 9;</code>
     */
    public Builder setAnnualAvgEarning(double value) {
      
      annualAvgEarning_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *Average yearly earning
     * </pre>
     *
     * <code>double AnnualAvgEarning = 9;</code>
     */
    public Builder clearAnnualAvgEarning() {
      
      annualAvgEarning_ = 0D;
      onChanged();
      return this;
    }

    private double totalEarning_ ;
    /**
     * <pre>
     *total earning
     * </pre>
     *
     * <code>double totalEarning = 10;</code>
     */
    public double getTotalEarning() {
      return totalEarning_;
    }
    /**
     * <pre>
     *total earning
     * </pre>
     *
     * <code>double totalEarning = 10;</code>
     */
    public Builder setTotalEarning(double value) {
      
      totalEarning_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *total earning
     * </pre>
     *
     * <code>double totalEarning = 10;</code>
     */
    public Builder clearTotalEarning() {
      
      totalEarning_ = 0D;
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


    // @@protoc_insertion_point(builder_scope:ProductivityReportResponse)
  }

  // @@protoc_insertion_point(class_scope:ProductivityReportResponse)
  private static final ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse();
  }

  public static ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ProductivityReportResponse>
      PARSER = new com.google.protobuf.AbstractParser<ProductivityReportResponse>() {
    @java.lang.Override
    public ProductivityReportResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ProductivityReportResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ProductivityReportResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ProductivityReportResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.smartwarehouse.project.warehouseManagement.ProductivityReportResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

