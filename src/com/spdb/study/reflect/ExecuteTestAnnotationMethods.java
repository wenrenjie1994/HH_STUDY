package com.spdb.study.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 23:43
 */
public class ExecuteTestAnnotationMethods {
    public static void main(String[] args) throws Exception {
        /**
         * 动态加载类
         * @author Mr.Longyx
         * @date 2020/6/21 23:43
         */
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        Class<?> clazz = Class.forName(className);
        /**
         * 动态获取所有的方法
         * @author Mr.Longyx
         * @date 2020/6/21 23:43
         */
        Method[] methods = clazz.getDeclaredMethods();

        Object obj = clazz.newInstance();
        for (Method method : methods) {
            /**
             * 检查一个方法的注解信息
             * method.getAnnotation(被检查的注解类型)
             * 返回注册类型，如果为空，表示没有注解
             * 不为空，则表示找到了匹配的注解
             * @author Mr.Longyx
             * @date 2020/6/21 23:47
             */
            Test annotation = method.getAnnotation(Test.class);

            System.out.println(method+" "+annotation);

            /**
             * 执行包含注解的方法
             * @author Mr.Longyx
             * @date 2020/6/21 23:58
             */
            if (null != annotation){
                method.invoke(obj);
            }

        }

    }
}
