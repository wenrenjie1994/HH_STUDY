package com.spdb.study.reflect;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 21:56
 */
public class BaseMethod {
    public void test1(){
        System.out.println("java");
    }

    public void test2(){
        System.out.println("python");
    }

    protected void test3() {
        System.out.println("scala");
    }

    private String test4(String name,Integer age){
        return "hello, "+name+" "+age;
    }
}
