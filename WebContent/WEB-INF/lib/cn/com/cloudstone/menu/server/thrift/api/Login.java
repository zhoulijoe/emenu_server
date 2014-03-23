/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package cn.com.cloudstone.menu.server.thrift.api;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Login implements org.apache.thrift.TBase<Login, Login._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Login");

  private static final org.apache.thrift.protocol.TField SESSION_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("sessionId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField USERNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("username", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField USER_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("userType", org.apache.thrift.protocol.TType.I32, (short)3);

  public String sessionId; // required
  public String username; // required
  /**
   * 
   * @see UserType
   */
  public UserType userType; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SESSION_ID((short)1, "sessionId"),
    USERNAME((short)2, "username"),
    /**
     * 
     * @see UserType
     */
    USER_TYPE((short)3, "userType");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SESSION_ID
          return SESSION_ID;
        case 2: // USERNAME
          return USERNAME;
        case 3: // USER_TYPE
          return USER_TYPE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SESSION_ID, new org.apache.thrift.meta_data.FieldMetaData("sessionId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USERNAME, new org.apache.thrift.meta_data.FieldMetaData("username", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.USER_TYPE, new org.apache.thrift.meta_data.FieldMetaData("userType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, UserType.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Login.class, metaDataMap);
  }

  public Login() {
  }

  public Login(
    String sessionId,
    String username,
    UserType userType)
  {
    this();
    this.sessionId = sessionId;
    this.username = username;
    this.userType = userType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Login(Login other) {
    if (other.isSetSessionId()) {
      this.sessionId = other.sessionId;
    }
    if (other.isSetUsername()) {
      this.username = other.username;
    }
    if (other.isSetUserType()) {
      this.userType = other.userType;
    }
  }

  public Login deepCopy() {
    return new Login(this);
  }

  @Override
  public void clear() {
    this.sessionId = null;
    this.username = null;
    this.userType = null;
  }

  public String getSessionId() {
    return this.sessionId;
  }

  public Login setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  public void unsetSessionId() {
    this.sessionId = null;
  }

  /** Returns true if field sessionId is set (has been assigned a value) and false otherwise */
  public boolean isSetSessionId() {
    return this.sessionId != null;
  }

  public void setSessionIdIsSet(boolean value) {
    if (!value) {
      this.sessionId = null;
    }
  }

  public String getUsername() {
    return this.username;
  }

  public Login setUsername(String username) {
    this.username = username;
    return this;
  }

  public void unsetUsername() {
    this.username = null;
  }

  /** Returns true if field username is set (has been assigned a value) and false otherwise */
  public boolean isSetUsername() {
    return this.username != null;
  }

  public void setUsernameIsSet(boolean value) {
    if (!value) {
      this.username = null;
    }
  }

  /**
   * 
   * @see UserType
   */
  public UserType getUserType() {
    return this.userType;
  }

  /**
   * 
   * @see UserType
   */
  public Login setUserType(UserType userType) {
    this.userType = userType;
    return this;
  }

  public void unsetUserType() {
    this.userType = null;
  }

  /** Returns true if field userType is set (has been assigned a value) and false otherwise */
  public boolean isSetUserType() {
    return this.userType != null;
  }

  public void setUserTypeIsSet(boolean value) {
    if (!value) {
      this.userType = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case SESSION_ID:
      if (value == null) {
        unsetSessionId();
      } else {
        setSessionId((String)value);
      }
      break;

    case USERNAME:
      if (value == null) {
        unsetUsername();
      } else {
        setUsername((String)value);
      }
      break;

    case USER_TYPE:
      if (value == null) {
        unsetUserType();
      } else {
        setUserType((UserType)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case SESSION_ID:
      return getSessionId();

    case USERNAME:
      return getUsername();

    case USER_TYPE:
      return getUserType();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case SESSION_ID:
      return isSetSessionId();
    case USERNAME:
      return isSetUsername();
    case USER_TYPE:
      return isSetUserType();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Login)
      return this.equals((Login)that);
    return false;
  }

  public boolean equals(Login that) {
    if (that == null)
      return false;

    boolean this_present_sessionId = true && this.isSetSessionId();
    boolean that_present_sessionId = true && that.isSetSessionId();
    if (this_present_sessionId || that_present_sessionId) {
      if (!(this_present_sessionId && that_present_sessionId))
        return false;
      if (!this.sessionId.equals(that.sessionId))
        return false;
    }

    boolean this_present_username = true && this.isSetUsername();
    boolean that_present_username = true && that.isSetUsername();
    if (this_present_username || that_present_username) {
      if (!(this_present_username && that_present_username))
        return false;
      if (!this.username.equals(that.username))
        return false;
    }

    boolean this_present_userType = true && this.isSetUserType();
    boolean that_present_userType = true && that.isSetUserType();
    if (this_present_userType || that_present_userType) {
      if (!(this_present_userType && that_present_userType))
        return false;
      if (!this.userType.equals(that.userType))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Login other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Login typedOther = (Login)other;

    lastComparison = Boolean.valueOf(isSetSessionId()).compareTo(typedOther.isSetSessionId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSessionId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sessionId, typedOther.sessionId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUsername()).compareTo(typedOther.isSetUsername());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUsername()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.username, typedOther.username);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserType()).compareTo(typedOther.isSetUserType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userType, typedOther.userType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // SESSION_ID
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.sessionId = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // USERNAME
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.username = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // USER_TYPE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.userType = UserType.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.sessionId != null) {
      oprot.writeFieldBegin(SESSION_ID_FIELD_DESC);
      oprot.writeString(this.sessionId);
      oprot.writeFieldEnd();
    }
    if (this.username != null) {
      oprot.writeFieldBegin(USERNAME_FIELD_DESC);
      oprot.writeString(this.username);
      oprot.writeFieldEnd();
    }
    if (this.userType != null) {
      oprot.writeFieldBegin(USER_TYPE_FIELD_DESC);
      oprot.writeI32(this.userType.getValue());
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Login(");
    boolean first = true;

    sb.append("sessionId:");
    if (this.sessionId == null) {
      sb.append("null");
    } else {
      sb.append(this.sessionId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("username:");
    if (this.username == null) {
      sb.append("null");
    } else {
      sb.append(this.username);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("userType:");
    if (this.userType == null) {
      sb.append("null");
    } else {
      sb.append(this.userType);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}
