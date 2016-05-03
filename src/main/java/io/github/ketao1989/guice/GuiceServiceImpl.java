/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.guice;

import com.google.inject.Singleton;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: kxcoder Date: 15-9-14 Time: 下午3:17
 * @version: \$Id\$
 */
@Singleton
public class GuiceServiceImpl {

    public String getRole(String name) {

        if (StringUtils.equals("ktcoder",name)){
            return "admin";
        }else {
            return "";
        }
    }
}
