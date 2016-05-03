/*
* Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
*/
package io.github.ketao1989.guice;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: kxcoder Date: 15-9-14 Time: 下午3:19
 * @version: \$Id\$
 */
@Singleton
public class GuiceBiz {

    @Inject
    private GuiceServiceImpl guiceServiceImpl;

    public GuiceBiz(){
        System.out.println("----cccc----");
    }

    // public void setGuiceServiceImpl(GuiceServiceImpl guiceServiceImpl) {
    // this.guiceServiceImpl = guiceServiceImpl;
    // }

    public void sysBizHello(String name){

        System.out.println(guiceServiceImpl.getRole(name));

    }

    public String concatString(String name, String prefix) {

        String res = guiceServiceImpl.getRole(name);

        if (StringUtils.isBlank(res)){
            return prefix + "Guest";
        }else {
            return prefix + "Admin";
        }


    }

    public String helloRole(String name){

        String res = guiceServiceImpl.getRole(name);

        if (StringUtils.isBlank(res)){
            return "hello " + "Guest";
        }

        return "hello " + "Admin";
    }
}
