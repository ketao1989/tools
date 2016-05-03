/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.thrift.impl;

import io.github.ketao1989.thrift.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

/**
 * @author: ketao Date: 15-8-5 Time: 下午5:41
 * @version: \$Id\$
 */
public class SayHelloMethodCallback implements AsyncMethodCallback<Hello.AsyncClient.sayHello_call> {

    public void onComplete(Hello.AsyncClient.sayHello_call response) {
        try {
            System.out.println(response.getResult());
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public void onError(Exception exception) {
        exception.printStackTrace();
    }
}
