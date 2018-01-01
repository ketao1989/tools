/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.dubbo.provider;

import com.alibaba.fastjson.JSON;

import io.github.ketao1989.dubbo.api.IUserBiz;
import io.github.ketao1989.dubbo.api.UserRequest;

/**
 * @author: ketao Date: 15-7-30 Time: 下午8:06
 * @version: \$Id\$
 */
public class UserBizImpl implements IUserBiz {

  public String queryName(long id) {
    return "test_" + id;
  }

  @Override
  public String addUser(UserRequest request) {
    return JSON.toJSONString(request);
  }
}
