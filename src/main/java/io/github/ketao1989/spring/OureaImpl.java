/*
 * Copyright (c) 2015 taocoder.com. All Rights Reserved.
 */
package io.github.ketao1989.spring;

import com.taocoder.ourea.Ourea;
import org.apache.thrift.TException;

/**
 * @author tao.ke Date: 16/4/25 Time: 下午2:25
 */

public class OureaImpl implements Ourea.Iface {

    public String queryEcho(String request) throws TException {
        System.out.println("--------v1999" + request);
        return request + "v1999";
    }
}
