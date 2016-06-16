/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.cglib;

/**
 * @author tao.ke Date: 16/6/16 Time: 下午10:55
 */
public class CglibTest {

    public static void main(String[] args) {

        CustomerProcessor processor = ProxyBeanFactory.getProxyBean(CustomerProcessor.class);
        processor.onProcess("taocoder");

    }
}
