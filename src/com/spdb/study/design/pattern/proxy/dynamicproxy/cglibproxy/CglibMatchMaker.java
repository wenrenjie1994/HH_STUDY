package com.spdb.study.design.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib实现动态代理
 * @author Mr.Longyx
 * @date 2020年06月27日 23:17
 */
public class CglibMatchMaker implements MethodInterceptor {

    public Object getInstance(Class<?> clazz)throws Exception{
        /**
         * 相当于JDK动态代理中的Proxy 代理的工具类
         * @author Mr.Longyx
         * @date 2020/6/28 0:42
         * @param clazz
         * @return java.lang.Object
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);

        return enhancer.create();
    }

    /**
     *  该方法实现cglib的方法增强
     * @author Mr.Longyx
     * @date 2020/6/28 0:46
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return java.lang.Object
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        /**
         * 此处反射调用
         * @author Mr.Longyx
         * @date 2020/6/26 22:09
         * @param proxy
         * @param method
         * @param args
         * @return java.lang.Object
         */
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }

    private void before(){
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("请您静候佳音！");
    }

    private void after(){
        System.out.println("OK的话，准备迎接这段姻缘吧！");
    }
}
