/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author tao.ke Date: 16/6/16 Time: 下午11:20
 */
public class ProxyBeanFactory {

    @SuppressWarnings("unchecked")
    public static <T> T getProxyBean(Class<T> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new ProcessProxyHandler());
        enhancer.setClassLoader(ProxyBeanFactory.class.getClassLoader());
        return  (T) enhancer.create();
    }
}
