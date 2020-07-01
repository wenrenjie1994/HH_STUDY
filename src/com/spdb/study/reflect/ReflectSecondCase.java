package com.spdb.study.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 执行某个类中全部以test开头的无参数无返回值的非静态方法
 * Junit3 原型
 * @author Mr.Longyx
 * @date 2020年06月21日 22:19
 */
public class ReflectSecondCase {
    public static void main(String[] args) throws Exception {
        /**
         * 动态加载类
         * @author Mr.Longyx
         * @date 2020/6/21 22:19
         */
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        Class<?> clazz = Class.forName(className);

        Object obj = clazz.newInstance();
        /**
         * 动态获取一个类中所有的方法信息
         * @author Mr.Longyx
         * @date 2020/6/21 22:19
         */
        Method[] methods = clazz.getDeclaredMethods();

        /**
         * 迭代全部方法查找以test开头的方法
         * @author Mr.Longyx
         * @date 2020/6/21 22:19
         */

        for (Method m : methods) {
            if (m.getName().startsWith("test")){
                System.out.println(m);
                //动态执行方法
                m.invoke(obj);
            }
        }

    }
}
