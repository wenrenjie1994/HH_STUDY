package com.spdb.study.reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 *  反射调用私有方法
 * @author Mr.Longyx
 * @date 2020年06月21日 22:46
 */
public class Reflection {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入类名: ");
        String className = scan.nextLine();
        Class cls = Class.forName(className);
        /**
         * 1.找到私有方法
         * Class提供了根据方法签名找到指定方法信息的API
         * @author Mr.Longyx
         * @date 2020/6/21 22:47
         */
        String name="test4";
        /**
         * 类型列表 Class[]
         * String.class表示字符串的类型
         * int.class  表示int类型
         * @author Mr.Longyx
         * @date 2020/6/21 22:48
         */
        Class[] types={String.class,Integer.class};
        /**
         * 根据方法签名在cls上查找方法信息
         * @author Mr.Longyx
         * @date 2020/6/21 22:49
         */
        Method method = cls.getDeclaredMethod(name, types);
        /**
         * 找到私有方法
         * @author Mr.Longyx
         * @date 2020/6/21 22:49
         */
        System.out.println(method);
        /**
         * 执行私有方法 打开方法的执行权限!!违反封装!
         * @author Mr.Longyx
         * @date 2020/6/21 22:50
         */
        method.setAccessible(true);
        Object obj = cls.newInstance();
        Object value = method.invoke(obj,"Java",18);
        System.out.println(value);
    }
}
