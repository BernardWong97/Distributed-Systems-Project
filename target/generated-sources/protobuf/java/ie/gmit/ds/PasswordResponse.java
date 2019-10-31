// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

/**
 * Protobuf type {@code ie.gmit.ds.PasswordResponse}
 */
public  final class PasswordResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ie.gmit.ds.PasswordResponse)
    PasswordResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PasswordResponse.newBuilder() to construct.
  private PasswordResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PasswordResponse() {
    userName_ = "";
    hashedPassword_ = "";
    salt_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PasswordResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PasswordResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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

            userName_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            hashedPassword_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            salt_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
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
    return ie.gmit.ds.Password.internal_static_ie_gmit_ds_PasswordResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ie.gmit.ds.Password.internal_static_ie_gmit_ds_PasswordResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ie.gmit.ds.PasswordResponse.class, ie.gmit.ds.PasswordResponse.Builder.class);
  }

  public static final int USERNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object userName_;
  /**
   * <code>string userName = 1;</code>
   */
  public java.lang.String getUserName() {
    java.lang.Object ref = userName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userName_ = s;
      return s;
    }
  }
  /**
   * <code>string userName = 1;</code>
   */
  public com.google.protobuf.ByteString
      getUserNameBytes() {
    java.lang.Object ref = userName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int HASHEDPASSWORD_FIELD_NUMBER = 2;
  private volatile java.lang.Object hashedPassword_;
  /**
   * <code>string hashedPassword = 2;</code>
   */
  public java.lang.String getHashedPassword() {
    java.lang.Object ref = hashedPassword_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      hashedPassword_ = s;
      return s;
    }
  }
  /**
   * <code>string hashedPassword = 2;</code>
   */
  public com.google.protobuf.ByteString
      getHashedPasswordBytes() {
    java.lang.Object ref = hashedPassword_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      hashedPassword_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SALT_FIELD_NUMBER = 3;
  private volatile java.lang.Object salt_;
  /**
   * <code>string salt = 3;</code>
   */
  public java.lang.String getSalt() {
    java.lang.Object ref = salt_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      salt_ = s;
      return s;
    }
  }
  /**
   * <code>string salt = 3;</code>
   */
  public com.google.protobuf.ByteString
      getSaltBytes() {
    java.lang.Object ref = salt_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      salt_ = b;
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
    if (!getUserNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, userName_);
    }
    if (!getHashedPasswordBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, hashedPassword_);
    }
    if (!getSaltBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, salt_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUserNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, userName_);
    }
    if (!getHashedPasswordBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, hashedPassword_);
    }
    if (!getSaltBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, salt_);
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
    if (!(obj instanceof ie.gmit.ds.PasswordResponse)) {
      return super.equals(obj);
    }
    ie.gmit.ds.PasswordResponse other = (ie.gmit.ds.PasswordResponse) obj;

    if (!getUserName()
        .equals(other.getUserName())) return false;
    if (!getHashedPassword()
        .equals(other.getHashedPassword())) return false;
    if (!getSalt()
        .equals(other.getSalt())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getUserName().hashCode();
    hash = (37 * hash) + HASHEDPASSWORD_FIELD_NUMBER;
    hash = (53 * hash) + getHashedPassword().hashCode();
    hash = (37 * hash) + SALT_FIELD_NUMBER;
    hash = (53 * hash) + getSalt().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ie.gmit.ds.PasswordResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.PasswordResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.PasswordResponse parseFrom(
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
  public static Builder newBuilder(ie.gmit.ds.PasswordResponse prototype) {
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
   * Protobuf type {@code ie.gmit.ds.PasswordResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ie.gmit.ds.PasswordResponse)
      ie.gmit.ds.PasswordResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ie.gmit.ds.Password.internal_static_ie_gmit_ds_PasswordResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ie.gmit.ds.Password.internal_static_ie_gmit_ds_PasswordResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ie.gmit.ds.PasswordResponse.class, ie.gmit.ds.PasswordResponse.Builder.class);
    }

    // Construct using ie.gmit.ds.PasswordResponse.newBuilder()
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
      userName_ = "";

      hashedPassword_ = "";

      salt_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ie.gmit.ds.Password.internal_static_ie_gmit_ds_PasswordResponse_descriptor;
    }

    @java.lang.Override
    public ie.gmit.ds.PasswordResponse getDefaultInstanceForType() {
      return ie.gmit.ds.PasswordResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ie.gmit.ds.PasswordResponse build() {
      ie.gmit.ds.PasswordResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ie.gmit.ds.PasswordResponse buildPartial() {
      ie.gmit.ds.PasswordResponse result = new ie.gmit.ds.PasswordResponse(this);
      result.userName_ = userName_;
      result.hashedPassword_ = hashedPassword_;
      result.salt_ = salt_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ie.gmit.ds.PasswordResponse) {
        return mergeFrom((ie.gmit.ds.PasswordResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ie.gmit.ds.PasswordResponse other) {
      if (other == ie.gmit.ds.PasswordResponse.getDefaultInstance()) return this;
      if (!other.getUserName().isEmpty()) {
        userName_ = other.userName_;
        onChanged();
      }
      if (!other.getHashedPassword().isEmpty()) {
        hashedPassword_ = other.hashedPassword_;
        onChanged();
      }
      if (!other.getSalt().isEmpty()) {
        salt_ = other.salt_;
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
      ie.gmit.ds.PasswordResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ie.gmit.ds.PasswordResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object userName_ = "";
    /**
     * <code>string userName = 1;</code>
     */
    public java.lang.String getUserName() {
      java.lang.Object ref = userName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string userName = 1;</code>
     */
    public com.google.protobuf.ByteString
        getUserNameBytes() {
      java.lang.Object ref = userName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string userName = 1;</code>
     */
    public Builder setUserName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string userName = 1;</code>
     */
    public Builder clearUserName() {
      
      userName_ = getDefaultInstance().getUserName();
      onChanged();
      return this;
    }
    /**
     * <code>string userName = 1;</code>
     */
    public Builder setUserNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userName_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object hashedPassword_ = "";
    /**
     * <code>string hashedPassword = 2;</code>
     */
    public java.lang.String getHashedPassword() {
      java.lang.Object ref = hashedPassword_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        hashedPassword_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string hashedPassword = 2;</code>
     */
    public com.google.protobuf.ByteString
        getHashedPasswordBytes() {
      java.lang.Object ref = hashedPassword_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        hashedPassword_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string hashedPassword = 2;</code>
     */
    public Builder setHashedPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      hashedPassword_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string hashedPassword = 2;</code>
     */
    public Builder clearHashedPassword() {
      
      hashedPassword_ = getDefaultInstance().getHashedPassword();
      onChanged();
      return this;
    }
    /**
     * <code>string hashedPassword = 2;</code>
     */
    public Builder setHashedPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      hashedPassword_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object salt_ = "";
    /**
     * <code>string salt = 3;</code>
     */
    public java.lang.String getSalt() {
      java.lang.Object ref = salt_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        salt_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string salt = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSaltBytes() {
      java.lang.Object ref = salt_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        salt_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string salt = 3;</code>
     */
    public Builder setSalt(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      salt_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string salt = 3;</code>
     */
    public Builder clearSalt() {
      
      salt_ = getDefaultInstance().getSalt();
      onChanged();
      return this;
    }
    /**
     * <code>string salt = 3;</code>
     */
    public Builder setSaltBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      salt_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ie.gmit.ds.PasswordResponse)
  }

  // @@protoc_insertion_point(class_scope:ie.gmit.ds.PasswordResponse)
  private static final ie.gmit.ds.PasswordResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ie.gmit.ds.PasswordResponse();
  }

  public static ie.gmit.ds.PasswordResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PasswordResponse>
      PARSER = new com.google.protobuf.AbstractParser<PasswordResponse>() {
    @java.lang.Override
    public PasswordResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PasswordResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PasswordResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PasswordResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ie.gmit.ds.PasswordResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

