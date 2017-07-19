/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.spring;

/**
 * @author tao.ke Date: 15-3-20 Time: 上午10:24
 * @version \$Id$
 */
public class SpringBeanService {

    private SpringBeanService springBeanService;

    public void setSpringBeanService(SpringBeanService springBeanService) {
        this.springBeanService = springBeanService;
    }

    public void printBeanInfo() {
        System.out.println("===bean info ----=====");
        springBeanService.printAopInfo();
    }

    @AnnotationPoint
    protected void printAopInfo(){
        System.out.println("======invoking method =============");
    }
}
