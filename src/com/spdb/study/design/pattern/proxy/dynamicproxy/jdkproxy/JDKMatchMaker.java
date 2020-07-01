package com.spdb.study.design.pattern.proxy.dynamicproxy.jdkproxy;

import com.spdb.study.design.pattern.proxy.staticproxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 媒介类
 * @author Mr.Longyx
 * @date 2020年06月26日 21:38
 */
public class JDKMatchMaker implements InvocationHandler {
    /**
     * 此处持有对象的引用
     * @author Mr.Longyx
     * @date 2020/6/26 21:39
     */
    private Object person;

    public Object getInstance(Person person){
        this.person = person;
        Class<?> clazz = person.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
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
        Object obj = method.invoke(this.person,args);
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
