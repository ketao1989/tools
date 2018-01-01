/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.dubbo.api;

/**
 * @author: ketao Date: 15-7-30 Time: 下午8:05
 * @version: \$Id\$
 */
public interface IUserBiz {
    /**
     * 根据id获取用户名
     * 
     * @param id
     * @return
     */
    public String queryName(long id);

    public String addUser(UserRequest request);
}
