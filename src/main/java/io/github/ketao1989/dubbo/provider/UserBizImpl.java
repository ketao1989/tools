/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.dubbo.provider;

import io.github.ketao1989.dubbo.api.IUserBiz;

/**
 * @author: ketao Date: 15-7-30 Time: 下午8:06
 * @version: \$Id\$
 */
public class UserBizImpl implements IUserBiz {

    public String queryName(int id) {
        return "test_" + id;
    }
}
