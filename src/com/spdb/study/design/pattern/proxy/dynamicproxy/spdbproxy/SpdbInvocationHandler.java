package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;

import java.lang.reflect.Method;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 22:08
 */
public interface SpdbInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
