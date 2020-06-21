package com.spdb.study.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 动态加载类
 * 官网地址链接：https://docs.oracle.com/javase/8/docs/api/index.html(java.lang.reflect->Classes->Method)
 * @author Mr.Longyx
 * @date 2020年06月21日 21:11
 */
public class ReflectFirstCase {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个类名： ");
            String className = scanner.nextLine();
            Class<?> clazz = Class.forName(className);
            System.out.println(clazz);

            /**
             * 动态创建对象(前提：该类必须得有无参构造器)
             * 示例：所有的高级流都没有无参构造器，如BufferedReader,BufferedInputStream等
             * @author Mr.Longyx
             * @date 2020/6/21 21:25
             */
            Object obj = clazz.newInstance();
            System.out.println(obj);

            /**
             * 动态获取类的信息
             * 从clazz代表的类信息中获取全部的方法信息(返回一个数组，其中包含反映该Class对象表示的类或接口的所有已声明方法的Method对象，包括公共，受保护，默认（程序包）访问和私有方法，但不包括继承的方法)
             *@author Mr.Longyx
             * @date 2020/6/21 21:34
             */
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m.getName()+" "+m.getReturnType()+" "+" "+m.getParameterTypes()+" "+m.getParameterCount()+" ");

                String name = m.getName();
                if (name.startsWith("test")){
                    System.out.println("已正确执行");
                }
            }
;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
