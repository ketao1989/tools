/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author: ketao Date: 15-7-30 Time: 下午8:24
 * @version: \$Id\$
 */
public class UserBizProvider {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo/dubbo-provider.xml");
        context.start();

        System.in.read();
    }
}
