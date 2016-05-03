/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.spring;

import com.taocoder.ourea.Ourea;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author tao.ke Date: 15-3-20 Time: 上午10:27
 * @version \$Id$
 */
public class SpringBeanTest {

    public static void main(String[] args) throws Exception {

//        ClassPathResource resource = new ClassPathResource("bean.xml");
//        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//        reader.loadBeanDefinitions(resource);

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//client test
        Ourea.Iface oureaImpl = applicationContext.getBean("oureaImpl1",Ourea.Iface.class);

        while (true){
            try {
                System.out.println(oureaImpl.queryEcho("test"));
            }catch (Exception e){
                e.printStackTrace();
            }
            Thread.sleep(900);
        }

        // server test


//        SpringBeanService springBeanService = applicationContext.getBean("springBeanService", SpringBeanService.class);
//        springBeanService.printBeanInfo();
//
//        SpringBeanRefService refService = applicationContext.getBean("springBeanRefService",SpringBeanRefService.class);
//        refService.pringBeanInfos();
    }

}
