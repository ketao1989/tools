/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.jdk;

/**
 * @author tao.ke Date: 16/7/1 Time: 下午10:37
 */
public class ClazzB {

    static {
        System.out.println("execute B static block.......");
    }

    public ClazzB() {
        System.out.println("execute B construct block.......");
    }

    public void exeAClazz(){
        ClazzA a = new ClazzA();
    }
}
