/*
 * Copyright (c) 2014 Qunar.com. All Rights Reserved.
 */
package io.github.ketao1989.spring;

/**
 * @author tao.ke Date: 15-3-20 Time: 上午10:24
 * @version \$Id$
 */
public class SpringBeanService {


    public void printBeanInfo() {
        System.out.println("===bean info ----=====");
        printAopInfo();
    }

    @AnnotationPoint
    protected void printAopInfo(){
        System.out.println("======invoking method =============");
    }
}
