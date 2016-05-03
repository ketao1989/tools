/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author: kxcoder Date: 15-9-14 Time: 下午3:18
 * @version: \$Id\$
 */
public class TestGuice {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new GuiceModule());

        GuiceBiz guiceBiz = injector.getInstance(GuiceBiz.class);

        guiceBiz.sysBizHello("test");
        System.out.println(guiceBiz.concatString("ktcoder", "hello,"));

    }

}
