/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tao.ke Date: 16/6/16 Time: 下午11:13
 */
public class ProcessProxyHandler implements MethodInterceptor{

    private void before(){
        System.out.println("-------before process ------------");
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object ret = proxy.invokeSuper(obj,args);
        after();
        return ret;
    }


    private void after(){
        System.out.println("----------after process ------------");
    }
}
