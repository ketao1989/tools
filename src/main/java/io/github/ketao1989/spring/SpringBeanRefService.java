/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.spring;

/**
 * @author tao.ke Date: 15-3-20 Time: 上午10:34
 * @version \$Id$
 */
public class SpringBeanRefService {

    private SpringBeanService springBeanService;

    public SpringBeanRefService(SpringBeanService springBeanService) {
        this.springBeanService = springBeanService;
    }

    public void pringBeanInfos() {
        springBeanService.printBeanInfo();
        //springBeanService.printAopInfo();

        System.out.println("===ref beans info====");

    }
}
