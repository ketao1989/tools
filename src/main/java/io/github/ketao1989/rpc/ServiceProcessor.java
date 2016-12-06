package io.github.ketao1989.rpc;

import scala.tools.cmd.gen.AnyVals;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author: tao.ke Date: 2016/12/5 Time: 下午9:06
 * @version: \$Id$
 */
public class ServiceProcessor {

    public static final ServiceProcessor processor = new ServiceProcessor();

    private static final ConcurrentMap<String, Object> PROCESSOR_INSTANCE_MAP = new ConcurrentHashMap<String, Object>();


    public boolean publish(Class clazz, Object obj) {
        return PROCESSOR_INSTANCE_MAP.putIfAbsent(clazz.getName(), obj) != null;
    }

    public Object process(ServiceProtocol.ProtocolModel model) {
        try {
            Class clazz = Class.forName(model.getClazz());

            Class[] types = new Class[model.getArgTypes().length];
            for (int i = 0; i < types.length; i++) {
                types[i] = Class.forName(model.getArgTypes()[i]);
            }

            Method method = clazz.getMethod(model.getMethod(), types);

            Object obj = PROCESSOR_INSTANCE_MAP.get(model.getClazz());
            if (obj == null) {
                return null;
            }

            return method.invoke(obj, model.getArgs());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
