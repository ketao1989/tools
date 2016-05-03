/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.thrift.client;

import io.github.ketao1989.thrift.Hello;
import io.github.ketao1989.thrift.impl.SayHelloMethodCallback;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TNonblockingSocket;

/**
 * @author: ketao Date: 15-8-4 Time: 下午8:55
 * @version: \$Id\$
 */
public class AsyncClient {

    private void invoke() {
        try {

            Hello.AsyncClient asyncClient = new Hello.AsyncClient(new TBinaryProtocol.Factory(),
                    new TAsyncClientManager(), new TNonblockingSocket("127.0.0.1", 8088));

//            System.out.println(Hello.sayHello_result.class.getCanonicalName());

//            asyncClient.sayHello(1, 1, new AsyncMethodCallback() {
//
//                public void onComplete(Object response) {
//
//                    Hello.AsyncClient.sayHello_call call = (Hello.AsyncClient.sayHello_call) response;
//
//                    try {
//                        System.out.println(call.getResult());
//                    } catch (TException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                public void onError(Exception exception) {
//                    exception.printStackTrace();
//                }
//            });

            asyncClient.sayHello(1,1,new SayHelloMethodCallback());

            System.out.println("----------");

        } catch (Exception e) {

            System.out.println("exception------");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        AsyncClient client = new AsyncClient();
        client.invoke();

        // 必须sleep，否则未request server就exit了
        Thread.sleep(100);
    }
}
