package io.github.ketao1989.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: tao.ke Date: 2016/12/5 Time: 下午9:58
 * @version: \$Id$
 */
public class ServiceProxyClient {

    public static <T> T getInstance(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] {clazz}, new ServiceProxy(clazz));
    }

    public static class ServiceProxy implements InvocationHandler {

        private Class clazz;

        public ServiceProxy(Class clazz) {
            this.clazz = clazz;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            ServiceProtocol.ProtocolModel model = new ServiceProtocol.ProtocolModel();
            model.setClazz(clazz.getName());
            model.setMethod(method.getName());
            model.setArgs(args);

            String[] argType = new String[method.getParameterTypes().length];
            for (int i = 0; i < argType.length; i++) {
                argType[i] = method.getParameterTypes()[i].getName();
            }
            model.setArgTypes(argType);

            byte[] req = ServiceProtocol.protocol.encode(model);
            byte[] rsp = ClientRemoter.client.getDataRemote(req);
            return ServiceProtocol.protocol.decode(rsp, method.getReturnType());
        }
    }
}
