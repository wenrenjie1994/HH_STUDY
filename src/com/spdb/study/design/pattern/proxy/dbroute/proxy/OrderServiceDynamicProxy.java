package com.spdb.study.design.pattern.proxy.dbroute.proxy;

import com.spdb.study.design.pattern.proxy.dbroute.db.DynamicDataSource;
import com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy.SpdbClassLoader;
import com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy.SpdbInvocationHandler;
import com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy.SpdbProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 动态代理实现动态切换数据源
 * @author Mr.Longyx
 * @date 2020年06月26日 21:05
 */
public class OrderServiceDynamicProxy implements InvocationHandler {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    Object proxyObj;

    public Object getInstance(Object proxyObj){
        this.proxyObj = proxyObj;
        Class<?> clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object obj = method.invoke(proxyObj,args);
        after();
        return obj;
    }

    /**
     * 进行数据源的切换
     * target:订单对象Order
     * @author Mr.Longyx
     * @date 2020/6/27 23:01
     */
    private void before(Object target) {
        System.out.println("Proxy before method");
        try {
            //约定优于配置
            Long time = (Long)target.getClass().getMethod("getCreateTime").invoke(target);
            Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
            System.out.println("动态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据");
            DynamicDataSource.set(dbRouter);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 还原最初的数据源
     * @author Mr.Longyx
     * @date 2020/6/27 23:01
     */
    private void after() {
        System.out.println("Proxy after method");
        DynamicDataSource.restore();
    }
}
