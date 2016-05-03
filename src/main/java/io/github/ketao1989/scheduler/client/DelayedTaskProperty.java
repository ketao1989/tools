/*
 * Copyright (c) 2015 ketao1989.github.io. All Rights Reserved.
 */
package io.github.ketao1989.scheduler.client;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author tao.ke Date: 16/1/2 Time: 下午5:37
 */
public class DelayedTaskProperty implements Serializable {

    private static final long serialVersionUID = 6227226019751603874L;

    private String classFullName;

    private String methodName;

    private Object[] args;

    /**
     * 路由规则的key,如果不设置,则随机路由到不同的分区
     */
    private int routeKey;

    public String getClassFullName() {
        return classFullName;
    }

    public void setClassFullName(String classFullName) {
        this.classFullName = classFullName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public int getRouteKey() {
        return routeKey;
    }

    public void setRouteKey(int routeKey) {
        this.routeKey = routeKey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
