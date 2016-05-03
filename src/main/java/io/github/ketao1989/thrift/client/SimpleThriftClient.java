/*
 * Copyright (c) 2015 taocoder.com. All Rights Reserved.
 */
package io.github.ketao1989.thrift.client;

import io.github.ketao1989.jackson.JsonUtils;
import io.github.ketao1989.thrift.Hello;
import io.github.ketao1989.thrift.HelloResult;
import org.apache.thrift.TApplicationException;
import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TMessageType;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.DocFlavor;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author ketao Date: 2015/7/16 Time: 11:27
 * @version \$Id$
 */
public class SimpleThriftClient {

    private static final Logger logger = LoggerFactory.getLogger(SimpleThriftClient.class);

    public void simple(int arg1, int arg2) {

        TTransport transport = null;

        try {
            transport = new TSocket("127.0.0.1", 8589);
            TProtocol protocol = new TBinaryProtocol(transport);
            Hello.Client client = new Hello.Client(protocol);
            transport.open();

            HelloResult result = client.sayHello(arg1, arg2);

            logger.info("==========Start============");

            logger.info(result.toString());

            logger.info("==========END============");

        } catch (Exception e) {
            logger.error("client invoke fail. ", e);
        } finally {
            if (transport != null) {
                transport.close();
            }
        }
    }

    /**
     * 一个超级牛逼的实现
     *
     * 将需要执行的thrift调用，二进制化，存放在数据库中。然后在某个时刻，将这个二进制流写入到transport中，继续执行该thrift调用。
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        // 将需要执行的二进制流作为transport，保存起来，不写入socket中
        ByteArrayOutputStream baos_ = new ByteArrayOutputStream();
        TIOStreamTransport transport = new TIOStreamTransport(baos_);
        TProtocol protocol = new TBinaryProtocol(transport);

        // 需要执行的API类,一般是数据库中获取类名字符串
        String className = Hello.class.getCanonicalName();
        // 和正常一样，需要client一个thrift客户端，由于是内部类，所以反射时，使用$分隔
        Class cl = Class.forName(className + "$" + "Client");

        TServiceClient client = (TServiceClient) cl.getConstructor(TProtocol.class).newInstance(protocol);
        System.out.println(client);

        String methodName = "send" + "_" + "sayHello";
        Class[] paramTypes = new Class[] { int.class, int.class };

        Method method = cl.getMethod(methodName, paramTypes);
        System.out.println(method);
        method.invoke(client, 1, 1);

        // 转换为字节流，保存起来
        byte[] result = baos_.toByteArray();
        System.out.println(Arrays.toString(result));

        /**
         * 开始写socket，将上面的字节流拿过来处理，和正常使用流程一致
         */
        TTransport tTransport = new TSocket("127.0.0.1", 8589, 3000);
        tTransport.open();
        TProtocol iprot_ = new TBinaryProtocol(tTransport);

        // 写入字节流到socket
        tTransport.write(result);
        tTransport.flush();

        // 构造返回类型的类，通过反射机制
        String fullName = Hello.class.getCanonicalName();
        String resultClassName = fullName + "$" + "sayHello" + "_result";
        Class resultClass = Class.forName(resultClassName);
        System.out.println(resultClass);

        TBase res = (TBase) (resultClass.newInstance());

        // 开始获取返回流
        TMessage msg = iprot_.readMessageBegin();
        if (msg.type == TMessageType.EXCEPTION) {
            TApplicationException x = TApplicationException.read(iprot_);
            iprot_.readMessageEnd();
            throw x;
        }

        // 将返回二进制流transport读入到前面构造的返回类对象中
        res.read(iprot_);
        iprot_.readMessageEnd();
        System.out.println(res.toString());

        // 获取返回对象中的某个属性值
        HelloResult helloResult = (HelloResult) res.getFieldValue(res.fieldForId(0));
        System.out.println(helloResult.name);

//         SimpleThriftClient client = new SimpleThriftClient();
//         client.simple(1,4);

    }
}
