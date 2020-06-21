package com.spdb.study.reflect;

/**
 * 执行一个类中全部以@Test标注的方法
 * JUnit 4 原型
 * @author Mr.Longyx
 * @date 2020年06月21日 23:35
 */
public class TestCase {
    @Test
    public void hello(){
        System.out.println("Hello()");
    }
    @Test
    public void helloJava(){
        System.out.println("Hello Java");
    }

    public void annotation(){
        System.out.println("self");
    }

    @Test
    public void happy(){
        System.out.println("happy");
    }
}
