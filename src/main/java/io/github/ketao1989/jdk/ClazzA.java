/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.jdk;

/**
 * @author tao.ke Date: 16/7/1 Time: 下午10:36
 */
public class ClazzA {

    static {
        System.out.println("execute A static block.......");
    }

    public ClazzA() {
        System.out.println("execute A construct block.......");
    }
}
