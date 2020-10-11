package com.longyx.study.design.pattern.proxy.dynamicproxy.longyxproxy;

import java.lang.reflect.Method;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 22:08
 */
public interface LongyxInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
