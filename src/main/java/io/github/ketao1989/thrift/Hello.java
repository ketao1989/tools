/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package io.github.ketao1989.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-7-16")
public class Hello {

  public interface Iface {

    public HelloResult sayHello(int word, int sword) throws TException;

  }

  public interface AsyncIface {

    public void sayHello(int word, int sword, AsyncMethodCallback resultHandler) throws TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public HelloResult sayHello(int word, int sword) throws TException
    {
      send_sayHello(word, sword);
      return recv_sayHello();
    }

    public void send_sayHello(int word, int sword) throws TException
    {
      sayHello_args args = new sayHello_args();
      args.setWord(word);
      args.setSword(sword);
      sendBase("sayHello", args);
    }

    public HelloResult recv_sayHello() throws TException
    {
      sayHello_result result = new sayHello_result();
      receiveBase(result, "sayHello");
      if (result.isSetSuccess()) {
        return result.success;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "sayHello failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void sayHello(int word, int sword, AsyncMethodCallback resultHandler) throws TException {
      checkReady();
      sayHello_call method_call = new sayHello_call(word, sword, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class sayHello_call extends org.apache.thrift.async.TAsyncMethodCall {
      private int word;
      private int sword;
      public sayHello_call(int word, int sword, AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.word = word;
        this.sword = sword;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("sayHello", org.apache.thrift.protocol.TMessageType.CALL, 0));
        sayHello_args args = new sayHello_args();
        args.setWord(word);
        args.setSword(sword);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public HelloResult getResult() throws TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_sayHello();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("sayHello", new sayHello());
      return processMap;
    }

    public static class sayHello<I extends Iface> extends org.apache.thrift.ProcessFunction<I, sayHello_args> {
      public sayHello() {
        super("sayHello");
      }

      public sayHello_args getEmptyArgsInstance() {
        return new sayHello_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public sayHello_result getResult(I iface, sayHello_args args) throws TException {
        sayHello_result result = new sayHello_result();
        result.success = iface.sayHello(args.word, args.sword);
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("sayHello", new sayHello());
      return processMap;
    }

    public static class sayHello<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, sayHello_args, HelloResult> {
      public sayHello() {
        super("sayHello");
      }

      public sayHello_args getEmptyArgsInstance() {
        return new sayHello_args();
      }

      public AsyncMethodCallback<HelloResult> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<HelloResult>() { 
          public void onComplete(HelloResult o) {
            sayHello_result result = new sayHello_result();
            result.success = o;
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            sayHello_result result = new sayHello_result();
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, sayHello_args args, AsyncMethodCallback<HelloResult> resultHandler) throws TException {
        iface.sayHello(args.word, args.sword,resultHandler);
      }
    }

  }

  public static class sayHello_args implements org.apache.thrift.TBase<sayHello_args, sayHello_args._Fields>, java.io.Serializable, Cloneable, Comparable<sayHello_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("sayHello_args");

    private static final org.apache.thrift.protocol.TField WORD_FIELD_DESC = new org.apache.thrift.protocol.TField("word", org.apache.thrift.protocol.TType.I32, (short)1);
    private static final org.apache.thrift.protocol.TField SWORD_FIELD_DESC = new org.apache.thrift.protocol.TField("sword", org.apache.thrift.protocol.TType.I32, (short)2);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new sayHello_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new sayHello_argsTupleSchemeFactory());
    }

    public int word; // required
    public int sword; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      WORD((short)1, "word"),
      SWORD((short)2, "sword");

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
          case 1: // WORD
            return WORD;
          case 2: // SWORD
            return SWORD;
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
    private static final int __WORD_ISSET_ID = 0;
    private static final int __SWORD_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.WORD, new org.apache.thrift.meta_data.FieldMetaData("word", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32          , "int")));
      tmpMap.put(_Fields.SWORD, new org.apache.thrift.meta_data.FieldMetaData("sword", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32          , "short")));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(sayHello_args.class, metaDataMap);
    }

    public sayHello_args() {
    }

    public sayHello_args(
      int word,
      int sword)
    {
      this();
      this.word = word;
      setWordIsSet(true);
      this.sword = sword;
      setSwordIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public sayHello_args(sayHello_args other) {
      __isset_bitfield = other.__isset_bitfield;
      this.word = other.word;
      this.sword = other.sword;
    }

    public sayHello_args deepCopy() {
      return new sayHello_args(this);
    }

    
    public void clear() {
      setWordIsSet(false);
      this.word = 0;
      setSwordIsSet(false);
      this.sword = 0;
    }

    public int getWord() {
      return this.word;
    }

    public sayHello_args setWord(int word) {
      this.word = word;
      setWordIsSet(true);
      return this;
    }

    public void unsetWord() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __WORD_ISSET_ID);
    }

    /** Returns true if field word is set (has been assigned a value) and false otherwise */
    public boolean isSetWord() {
      return EncodingUtils.testBit(__isset_bitfield, __WORD_ISSET_ID);
    }

    public void setWordIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __WORD_ISSET_ID, value);
    }

    public int getSword() {
      return this.sword;
    }

    public sayHello_args setSword(int sword) {
      this.sword = sword;
      setSwordIsSet(true);
      return this;
    }

    public void unsetSword() {
      __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __SWORD_ISSET_ID);
    }

    /** Returns true if field sword is set (has been assigned a value) and false otherwise */
    public boolean isSetSword() {
      return EncodingUtils.testBit(__isset_bitfield, __SWORD_ISSET_ID);
    }

    public void setSwordIsSet(boolean value) {
      __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __SWORD_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case WORD:
        if (value == null) {
          unsetWord();
        } else {
          setWord((Integer)value);
        }
        break;

      case SWORD:
        if (value == null) {
          unsetSword();
        } else {
          setSword((Integer)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case WORD:
        return Integer.valueOf(getWord());

      case SWORD:
        return Integer.valueOf(getSword());

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case WORD:
        return isSetWord();
      case SWORD:
        return isSetSword();
      }
      throw new IllegalStateException();
    }

    
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof sayHello_args)
        return this.equals((sayHello_args)that);
      return false;
    }

    public boolean equals(sayHello_args that) {
      if (that == null)
        return false;

      boolean this_present_word = true;
      boolean that_present_word = true;
      if (this_present_word || that_present_word) {
        if (!(this_present_word && that_present_word))
          return false;
        if (this.word != that.word)
          return false;
      }

      boolean this_present_sword = true;
      boolean that_present_sword = true;
      if (this_present_sword || that_present_sword) {
        if (!(this_present_sword && that_present_sword))
          return false;
        if (this.sword != that.sword)
          return false;
      }

      return true;
    }

    
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_word = true;
      list.add(present_word);
      if (present_word)
        list.add(word);

      boolean present_sword = true;
      list.add(present_sword);
      if (present_sword)
        list.add(sword);

      return list.hashCode();
    }

    
    public int compareTo(sayHello_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetWord()).compareTo(other.isSetWord());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetWord()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.word, other.word);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetSword()).compareTo(other.isSetSword());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSword()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sword, other.sword);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    
    public String toString() {
      StringBuilder sb = new StringBuilder("sayHello_args(");
      boolean first = true;

      sb.append("word:");
      sb.append(this.word);
      first = false;
      if (!first) sb.append(", ");
      sb.append("sword:");
      sb.append(this.sword);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class sayHello_argsStandardSchemeFactory implements SchemeFactory {
      public sayHello_argsStandardScheme getScheme() {
        return new sayHello_argsStandardScheme();
      }
    }

    private static class sayHello_argsStandardScheme extends StandardScheme<sayHello_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, sayHello_args struct) throws TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // WORD
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.word = iprot.readI32();
                struct.setWordIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // SWORD
              if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                struct.sword = iprot.readI32();
                struct.setSwordIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, sayHello_args struct) throws TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldBegin(WORD_FIELD_DESC);
        oprot.writeI32(struct.word);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(SWORD_FIELD_DESC);
        oprot.writeI32(struct.sword);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class sayHello_argsTupleSchemeFactory implements SchemeFactory {
      public sayHello_argsTupleScheme getScheme() {
        return new sayHello_argsTupleScheme();
      }
    }

    private static class sayHello_argsTupleScheme extends TupleScheme<sayHello_args> {

      
      public void write(org.apache.thrift.protocol.TProtocol prot, sayHello_args struct) throws TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetWord()) {
          optionals.set(0);
        }
        if (struct.isSetSword()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetWord()) {
          oprot.writeI32(struct.word);
        }
        if (struct.isSetSword()) {
          oprot.writeI32(struct.sword);
        }
      }

      
      public void read(org.apache.thrift.protocol.TProtocol prot, sayHello_args struct) throws TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.word = iprot.readI32();
          struct.setWordIsSet(true);
        }
        if (incoming.get(1)) {
          struct.sword = iprot.readI32();
          struct.setSwordIsSet(true);
        }
      }
    }

  }

  public static class sayHello_result implements org.apache.thrift.TBase<sayHello_result, sayHello_result._Fields>, java.io.Serializable, Cloneable, Comparable<sayHello_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("sayHello_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short)0);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new sayHello_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new sayHello_resultTupleSchemeFactory());
    }

    public HelloResult success; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success");

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
          case 0: // SUCCESS
            return SUCCESS;
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
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HelloResult.class)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(sayHello_result.class, metaDataMap);
    }

    public sayHello_result() {
    }

    public sayHello_result(
      HelloResult success)
    {
      this();
      this.success = success;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public sayHello_result(sayHello_result other) {
      if (other.isSetSuccess()) {
        this.success = new HelloResult(other.success);
      }
    }

    public sayHello_result deepCopy() {
      return new sayHello_result(this);
    }

    
    public void clear() {
      this.success = null;
    }

    public HelloResult getSuccess() {
      return this.success;
    }

    public sayHello_result setSuccess(HelloResult success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((HelloResult)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      }
      throw new IllegalStateException();
    }

    
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof sayHello_result)
        return this.equals((sayHello_result)that);
      return false;
    }

    public boolean equals(sayHello_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      return true;
    }

    
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_success = true && (isSetSuccess());
      list.add(present_success);
      if (present_success)
        list.add(success);

      return list.hashCode();
    }

    
    public int compareTo(sayHello_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    
    public String toString() {
      StringBuilder sb = new StringBuilder("sayHello_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check for sub-struct validity
      if (success != null) {
        success.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class sayHello_resultStandardSchemeFactory implements SchemeFactory {
      public sayHello_resultStandardScheme getScheme() {
        return new sayHello_resultStandardScheme();
      }
    }

    private static class sayHello_resultStandardScheme extends StandardScheme<sayHello_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, sayHello_result struct) throws TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.success = new HelloResult();
                struct.success.read(iprot);
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, sayHello_result struct) throws TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          struct.success.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class sayHello_resultTupleSchemeFactory implements SchemeFactory {
      public sayHello_resultTupleScheme getScheme() {
        return new sayHello_resultTupleScheme();
      }
    }

    private static class sayHello_resultTupleScheme extends TupleScheme<sayHello_result> {

      
      public void write(org.apache.thrift.protocol.TProtocol prot, sayHello_result struct) throws TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetSuccess()) {
          struct.success.write(oprot);
        }
      }

      
      public void read(org.apache.thrift.protocol.TProtocol prot, sayHello_result struct) throws TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.success = new HelloResult();
          struct.success.read(iprot);
          struct.setSuccessIsSet(true);
        }
      }
    }

  }

}
