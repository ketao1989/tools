package io.github.ketao1989.rpc;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.ParseException;
import io.github.ketao1989.jackson.JsonUtils;

import java.lang.reflect.Method;

/**
 * 很明显，这里使用JSON来序列化和反序列化RPC调用传递的数据
 *
 * @author: tao.ke Date: 2016/12/5 Time: 下午8:59
 * @version: \$Id$
 */
public class ServiceProtocol {

    public static final ServiceProtocol protocol = new ServiceProtocol();

    /**
     * 将对象序列化为字符串字节
     */
    public byte[] encode(Object o) {
        return JsonUtils.encode(o).getBytes();
    }

    /**
     * 反序列化成字符串
     */
    public <T> T decode(byte[] data, Class<T> clazz) {
        return JsonUtils.decode(new String(data), clazz);
    }

    /**
     * 编解码模型
     */
    public static class ProtocolModel {
        private String clazz;
        private String method;
        private String[] argTypes;
        private Object[] args;

        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String[] getArgTypes() {
            return argTypes;
        }

        public void setArgTypes(String[] argTypes) {
            this.argTypes = argTypes;
        }

        public Object[] getArgs() {
            return args;
        }

        public void setArgs(Object[] args) {
            this.args = args;
        }
    }
}
