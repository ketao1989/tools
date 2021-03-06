/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 * 
 * @generated
 */
package com.taocoder.ourea;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;
import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked" })
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2016-4-25")
public class Ourea {

    public interface Iface {

        public String queryEcho(String request) throws org.apache.thrift.TException;

    }

    public interface AsyncIface {

        public void queryEcho(String request, org.apache.thrift.async.AsyncMethodCallback resultHandler)
                throws org.apache.thrift.TException;

    }

    public static class Client extends org.apache.thrift.TServiceClient implements Iface {
        public Client(org.apache.thrift.protocol.TProtocol prot) {
            super(prot, prot);
        }

        public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
            super(iprot, oprot);
        }

        public String queryEcho(String request) throws org.apache.thrift.TException {
            send_queryEcho(request);
            return recv_queryEcho();
        }

        public void send_queryEcho(String request) throws org.apache.thrift.TException {
            queryEcho_args args = new queryEcho_args();
            args.setRequest(request);
            sendBase("queryEcho", args);
        }

        public String recv_queryEcho() throws org.apache.thrift.TException {
            queryEcho_result result = new queryEcho_result();
            receiveBase(result, "queryEcho");
            if (result.isSetSuccess()) {
                return result.success;
            }
            throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT,
                    "queryEcho failed: unknown result");
        }

        public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
            public Factory() {
            }

            public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
                return new Client(prot);
            }

            public Client getClient(org.apache.thrift.protocol.TProtocol iprot,
                    org.apache.thrift.protocol.TProtocol oprot) {
                return new Client(iprot, oprot);
            }
        }

    }

    public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
        public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                org.apache.thrift.async.TAsyncClientManager clientManager,
                org.apache.thrift.transport.TNonblockingTransport transport) {
            super(protocolFactory, clientManager, transport);
        }

        public void queryEcho(String request, org.apache.thrift.async.AsyncMethodCallback resultHandler)
                throws org.apache.thrift.TException {
            checkReady();
            queryEcho_call method_call = new queryEcho_call(request, resultHandler, this, ___protocolFactory,
                    ___transport);
            this.___currentMethod = method_call;
            ___manager.call(method_call);
        }

        public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
            private org.apache.thrift.async.TAsyncClientManager clientManager;
            private org.apache.thrift.protocol.TProtocolFactory protocolFactory;

            public Factory(org.apache.thrift.async.TAsyncClientManager clientManager,
                    org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
                this.clientManager = clientManager;
                this.protocolFactory = protocolFactory;
            }

            public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
                return new AsyncClient(protocolFactory, clientManager, transport);
            }
        }

        public static class queryEcho_call extends org.apache.thrift.async.TAsyncMethodCall {
            private String request;

            public queryEcho_call(String request, org.apache.thrift.async.AsyncMethodCallback resultHandler,
                    org.apache.thrift.async.TAsyncClient client,
                    org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                    org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
                super(client, protocolFactory, transport, resultHandler, false);
                this.request = request;
            }

            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
                prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("queryEcho",
                        org.apache.thrift.protocol.TMessageType.CALL, 0));
                queryEcho_args args = new queryEcho_args();
                args.setRequest(request);
                args.write(prot);
                prot.writeMessageEnd();
            }

            public String getResult() throws org.apache.thrift.TException {
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
                        getFrameBuffer().array());
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
                return (new Client(prot)).recv_queryEcho();
            }
        }

    }

    public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I>
            implements org.apache.thrift.TProcessor {
        private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());

        public Processor(I iface) {
            super(iface, getProcessMap(
                    new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
        }

        protected Processor(I iface,
                Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
            super(iface, getProcessMap(processMap));
        }

        private static <I extends Iface> Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> getProcessMap(
                Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
            processMap.put("queryEcho", new queryEcho());
            return processMap;
        }

        public static class queryEcho<I extends Iface> extends org.apache.thrift.ProcessFunction<I, queryEcho_args> {
            public queryEcho() {
                super("queryEcho");
            }

            public queryEcho_args getEmptyArgsInstance() {
                return new queryEcho_args();
            }

            protected boolean isOneway() {
                return false;
            }

            public queryEcho_result getResult(I iface, queryEcho_args args) throws org.apache.thrift.TException {
                queryEcho_result result = new queryEcho_result();
                result.success = iface.queryEcho(args.request);
                return result;
            }
        }

    }

    public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
        private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());

        public AsyncProcessor(I iface) {
            super(iface, getProcessMap(
                    new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
        }

        protected AsyncProcessor(I iface,
                Map<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>> processMap) {
            super(iface, getProcessMap(processMap));
        }

        private static <I extends AsyncIface> Map<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>> getProcessMap(
                Map<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>> processMap) {
            processMap.put("queryEcho", new queryEcho());
            return processMap;
        }

        public static class queryEcho<I extends AsyncIface>
                extends org.apache.thrift.AsyncProcessFunction<I, queryEcho_args, String> {
            public queryEcho() {
                super("queryEcho");
            }

            public queryEcho_args getEmptyArgsInstance() {
                return new queryEcho_args();
            }

            public AsyncMethodCallback<String> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
                final org.apache.thrift.AsyncProcessFunction fcall = this;
                return new AsyncMethodCallback<String>() {
                    public void onComplete(String o) {
                        queryEcho_result result = new queryEcho_result();
                        result.success = o;
                        try {
                            fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
                            return;
                        } catch (Exception e) {
                            LOGGER.error("Exception writing to internal frame buffer", e);
                        }
                        fb.close();
                    }

                    public void onError(Exception e) {
                        byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
                        org.apache.thrift.TBase msg;
                        queryEcho_result result = new queryEcho_result();
                        {
                            msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
                            msg = (org.apache.thrift.TBase) new org.apache.thrift.TApplicationException(
                                    org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
                        }
                        try {
                            fcall.sendResponse(fb, msg, msgType, seqid);
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

            public void start(I iface, queryEcho_args args,
                    org.apache.thrift.async.AsyncMethodCallback<String> resultHandler) throws TException {
                iface.queryEcho(args.request, resultHandler);
            }
        }

    }

    public static class queryEcho_args implements org.apache.thrift.TBase<queryEcho_args, queryEcho_args._Fields>,
            java.io.Serializable, Cloneable, Comparable<queryEcho_args> {
        // isset id assignments
        public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
                "queryEcho_args");
        private static final org.apache.thrift.protocol.TField REQUEST_FIELD_DESC = new org.apache.thrift.protocol.TField(
                "request", org.apache.thrift.protocol.TType.STRING, (short) 1);
        private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();

        static {
            schemes.put(StandardScheme.class, new queryEcho_argsStandardSchemeFactory());
            schemes.put(TupleScheme.class, new queryEcho_argsTupleSchemeFactory());
        }

        static {
            Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
                    _Fields.class);
            tmpMap.put(_Fields.REQUEST, new org.apache.thrift.meta_data.FieldMetaData("request",
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryEcho_args.class, metaDataMap);
        }

        public String request; // required

        public queryEcho_args() {
        }

        public queryEcho_args(String request) {
            this();
            this.request = request;
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public queryEcho_args(queryEcho_args other) {
            if (other.isSetRequest()) {
                this.request = other.request;
            }
        }

        public queryEcho_args deepCopy() {
            return new queryEcho_args(this);
        }

        
        public void clear() {
            this.request = null;
        }

        public String getRequest() {
            return this.request;
        }

        public queryEcho_args setRequest(String request) {
            this.request = request;
            return this;
        }

        public void unsetRequest() {
            this.request = null;
        }

        /** Returns true if field request is set (has been assigned a value) and false otherwise */
        public boolean isSetRequest() {
            return this.request != null;
        }

        public void setRequestIsSet(boolean value) {
            if (!value) {
                this.request = null;
            }
        }

        public void setFieldValue(_Fields field, Object value) {
            switch (field) {
            case REQUEST:
                if (value == null) {
                    unsetRequest();
                } else {
                    setRequest((String) value);
                }
                break;

            }
        }

        public Object getFieldValue(_Fields field) {
            switch (field) {
            case REQUEST:
                return getRequest();

            }
            throw new IllegalStateException();
        }

        /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        public boolean isSet(_Fields field) {
            if (field == null) {
                throw new IllegalArgumentException();
            }

            switch (field) {
            case REQUEST:
                return isSetRequest();
            }
            throw new IllegalStateException();
        }

        
        public boolean equals(Object that) {
            if (that == null)
                return false;
            if (that instanceof queryEcho_args)
                return this.equals((queryEcho_args) that);
            return false;
        }

        public boolean equals(queryEcho_args that) {
            if (that == null)
                return false;

            boolean this_present_request = true && this.isSetRequest();
            boolean that_present_request = true && that.isSetRequest();
            if (this_present_request || that_present_request) {
                if (!(this_present_request && that_present_request))
                    return false;
                if (!this.request.equals(that.request))
                    return false;
            }

            return true;
        }

        
        public int hashCode() {
            List<Object> list = new ArrayList<Object>();

            boolean present_request = true && (isSetRequest());
            list.add(present_request);
            if (present_request)
                list.add(request);

            return list.hashCode();
        }

        
        public int compareTo(queryEcho_args other) {
            if (!getClass().equals(other.getClass())) {
                return getClass().getName().compareTo(other.getClass().getName());
            }

            int lastComparison = 0;

            lastComparison = Boolean.valueOf(isSetRequest()).compareTo(other.isSetRequest());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetRequest()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.request, other.request);
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
            schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
        }

        
        public String toString() {
            StringBuilder sb = new StringBuilder("queryEcho_args(");
            boolean first = true;

            sb.append("request:");
            if (this.request == null) {
                sb.append("null");
            } else {
                sb.append(this.request);
            }
            first = false;
            sb.append(")");
            return sb.toString();
        }

        public void validate() throws org.apache.thrift.TException {
            // check for required fields
            // check for sub-struct validity
        }

        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            try {
                write(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(out)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
            try {
                read(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(in)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            REQUEST((short) 1, "request");

            private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

            static {
                for (_Fields field : EnumSet.allOf(_Fields.class)) {
                    byName.put(field.getFieldName(), field);
                }
            }

            private final short _thriftId;
            private final String _fieldName;

            _Fields(short thriftId, String fieldName) {
                _thriftId = thriftId;
                _fieldName = fieldName;
            }

            /**
             * Find the _Fields constant that matches fieldId, or null if its not found.
             */
            public static _Fields findByThriftId(int fieldId) {
                switch (fieldId) {
                case 1: // REQUEST
                    return REQUEST;
                default:
                    return null;
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, throwing an exception if it is not found.
             */
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                _Fields fields = findByThriftId(fieldId);
                if (fields == null)
                    throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return fields;
            }

            /**
             * Find the _Fields constant that matches name, or null if its not found.
             */
            public static _Fields findByName(String name) {
                return byName.get(name);
            }

            public short getThriftFieldId() {
                return _thriftId;
            }

            public String getFieldName() {
                return _fieldName;
            }
        }

        private static class queryEcho_argsStandardSchemeFactory implements SchemeFactory {
            public queryEcho_argsStandardScheme getScheme() {
                return new queryEcho_argsStandardScheme();
            }
        }

        private static class queryEcho_argsStandardScheme extends StandardScheme<queryEcho_args> {

            public void read(org.apache.thrift.protocol.TProtocol iprot, queryEcho_args struct)
                    throws org.apache.thrift.TException {
                org.apache.thrift.protocol.TField schemeField;
                iprot.readStructBegin();
                while (true) {
                    schemeField = iprot.readFieldBegin();
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        break;
                    }
                    switch (schemeField.id) {
                    case 1: // REQUEST
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.request = iprot.readString();
                            struct.setRequestIsSet(true);
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

            public void write(org.apache.thrift.protocol.TProtocol oprot, queryEcho_args struct)
                    throws org.apache.thrift.TException {
                struct.validate();

                oprot.writeStructBegin(STRUCT_DESC);
                if (struct.request != null) {
                    oprot.writeFieldBegin(REQUEST_FIELD_DESC);
                    oprot.writeString(struct.request);
                    oprot.writeFieldEnd();
                }
                oprot.writeFieldStop();
                oprot.writeStructEnd();
            }

        }

        private static class queryEcho_argsTupleSchemeFactory implements SchemeFactory {
            public queryEcho_argsTupleScheme getScheme() {
                return new queryEcho_argsTupleScheme();
            }
        }

        private static class queryEcho_argsTupleScheme extends TupleScheme<queryEcho_args> {

            
            public void write(org.apache.thrift.protocol.TProtocol prot, queryEcho_args struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol oprot = (TTupleProtocol) prot;
                BitSet optionals = new BitSet();
                if (struct.isSetRequest()) {
                    optionals.set(0);
                }
                oprot.writeBitSet(optionals, 1);
                if (struct.isSetRequest()) {
                    oprot.writeString(struct.request);
                }
            }

            
            public void read(org.apache.thrift.protocol.TProtocol prot, queryEcho_args struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol iprot = (TTupleProtocol) prot;
                BitSet incoming = iprot.readBitSet(1);
                if (incoming.get(0)) {
                    struct.request = iprot.readString();
                    struct.setRequestIsSet(true);
                }
            }
        }

    }

    public static class queryEcho_result implements org.apache.thrift.TBase<queryEcho_result, queryEcho_result._Fields>,
            java.io.Serializable, Cloneable, Comparable<queryEcho_result> {
        // isset id assignments
        public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
                "queryEcho_result");
        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                "success", org.apache.thrift.protocol.TType.STRING, (short) 0);
        private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();

        static {
            schemes.put(StandardScheme.class, new queryEcho_resultStandardSchemeFactory());
            schemes.put(TupleScheme.class, new queryEcho_resultTupleSchemeFactory());
        }

        static {
            Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
                    _Fields.class);
            tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success",
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(queryEcho_result.class, metaDataMap);
        }

        public String success; // required

        public queryEcho_result() {
        }

        public queryEcho_result(String success) {
            this();
            this.success = success;
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public queryEcho_result(queryEcho_result other) {
            if (other.isSetSuccess()) {
                this.success = other.success;
            }
        }

        public queryEcho_result deepCopy() {
            return new queryEcho_result(this);
        }

        
        public void clear() {
            this.success = null;
        }

        public String getSuccess() {
            return this.success;
        }

        public queryEcho_result setSuccess(String success) {
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
                    setSuccess((String) value);
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
            if (that instanceof queryEcho_result)
                return this.equals((queryEcho_result) that);
            return false;
        }

        public boolean equals(queryEcho_result that) {
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

        
        public int compareTo(queryEcho_result other) {
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

        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
        }

        
        public String toString() {
            StringBuilder sb = new StringBuilder("queryEcho_result(");
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

        public void validate() throws org.apache.thrift.TException {
            // check for required fields
            // check for sub-struct validity
        }

        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            try {
                write(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(out)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
            try {
                read(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(in)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            SUCCESS((short) 0, "success");

            private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

            static {
                for (_Fields field : EnumSet.allOf(_Fields.class)) {
                    byName.put(field.getFieldName(), field);
                }
            }

            private final short _thriftId;
            private final String _fieldName;

            _Fields(short thriftId, String fieldName) {
                _thriftId = thriftId;
                _fieldName = fieldName;
            }

            /**
             * Find the _Fields constant that matches fieldId, or null if its not found.
             */
            public static _Fields findByThriftId(int fieldId) {
                switch (fieldId) {
                case 0: // SUCCESS
                    return SUCCESS;
                default:
                    return null;
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, throwing an exception if it is not found.
             */
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                _Fields fields = findByThriftId(fieldId);
                if (fields == null)
                    throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return fields;
            }

            /**
             * Find the _Fields constant that matches name, or null if its not found.
             */
            public static _Fields findByName(String name) {
                return byName.get(name);
            }

            public short getThriftFieldId() {
                return _thriftId;
            }

            public String getFieldName() {
                return _fieldName;
            }
        }

        private static class queryEcho_resultStandardSchemeFactory implements SchemeFactory {
            public queryEcho_resultStandardScheme getScheme() {
                return new queryEcho_resultStandardScheme();
            }
        }

        private static class queryEcho_resultStandardScheme extends StandardScheme<queryEcho_result> {

            public void read(org.apache.thrift.protocol.TProtocol iprot, queryEcho_result struct)
                    throws org.apache.thrift.TException {
                org.apache.thrift.protocol.TField schemeField;
                iprot.readStructBegin();
                while (true) {
                    schemeField = iprot.readFieldBegin();
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        break;
                    }
                    switch (schemeField.id) {
                    case 0: // SUCCESS
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.success = iprot.readString();
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

            public void write(org.apache.thrift.protocol.TProtocol oprot, queryEcho_result struct)
                    throws org.apache.thrift.TException {
                struct.validate();

                oprot.writeStructBegin(STRUCT_DESC);
                if (struct.success != null) {
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
                    oprot.writeString(struct.success);
                    oprot.writeFieldEnd();
                }
                oprot.writeFieldStop();
                oprot.writeStructEnd();
            }

        }

        private static class queryEcho_resultTupleSchemeFactory implements SchemeFactory {
            public queryEcho_resultTupleScheme getScheme() {
                return new queryEcho_resultTupleScheme();
            }
        }

        private static class queryEcho_resultTupleScheme extends TupleScheme<queryEcho_result> {

            
            public void write(org.apache.thrift.protocol.TProtocol prot, queryEcho_result struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol oprot = (TTupleProtocol) prot;
                BitSet optionals = new BitSet();
                if (struct.isSetSuccess()) {
                    optionals.set(0);
                }
                oprot.writeBitSet(optionals, 1);
                if (struct.isSetSuccess()) {
                    oprot.writeString(struct.success);
                }
            }

            
            public void read(org.apache.thrift.protocol.TProtocol prot, queryEcho_result struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol iprot = (TTupleProtocol) prot;
                BitSet incoming = iprot.readBitSet(1);
                if (incoming.get(0)) {
                    struct.success = iprot.readString();
                    struct.setSuccessIsSet(true);
                }
            }
        }

    }

}
