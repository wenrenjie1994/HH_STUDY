package com.lihang.annotation.myannotation;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: LI
 * Date: 2020/5/23
 */
public class DealMyAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class clazz = Class.forName("com.lihang.annotation.service.MyService");
        Method method = clazz.getMethod("getAll", Integer.class);
        boolean flag = method.isAnnotationPresent(MyAnnotation.class);
        if (flag){
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            System.out.println("反射获取age:"+myAnnotation.age());
            System.out.println("反射获取name:"+myAnnotation.name());
            System.out.println("反射获取array:"+myAnnotation.array());
        }
    }
}
