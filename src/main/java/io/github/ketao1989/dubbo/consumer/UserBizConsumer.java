/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.dubbo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

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


        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-provider");

        ReferenceConfig<GenericService> ref = new ReferenceConfig<>();

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");

        ref.setTimeout(1000);
        ref.setProtocol("dubbo");
        ref.setConnections(2);
        ref.setInterface("io.github.ketao1989.dubbo.api.IUserBiz");
        ref.setApplication(applicationConfig);
        ref.setRegistry(registryConfig);
        ref.setGeneric(true);

        GenericService service = ref.get();
        Object o = service.$invoke("queryName",new String[]{"long"},new Object[]{"12"});
        System.out.println(o);


        //IUserBiz userBiz =(IUserBiz)applicationContext.getBean("userBiz");
//        System.out.println(userBiz.queryName(12));

    }
}
