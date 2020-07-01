package com.spdb.study.design.pattern.singleton.register;



/**
 * @author Mr.Longyx
 * @date 2020年06月23日 15:16
 */
public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object obj = ContainerSingleton.getBean("com.spdb.study.reflect.BaseMethod");
        System.out.println(obj);
    }
}
