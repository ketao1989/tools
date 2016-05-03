/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.dubbo.consumer;

import io.github.ketao1989.dubbo.api.IUserBiz;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: ketao Date: 15-7-30 Time: 下午8:07
 * @version: \$Id\$
 */
public class UserBizConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("dubbo/dubbo-consumer.xml");
        applicationContext.start();

        IUserBiz userBiz =(IUserBiz)applicationContext.getBean("userBiz");
        System.out.println(userBiz.queryName(12));

    }
}
