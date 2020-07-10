package com.pan.segregation;

/**
 * @author zhaopan@163.com
 * @creat 2020-05-14 20:36
 */
public class Segregation1 {
    public static void main(String[] args) {

    }
}

interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class B implements Interface1{

    @Override
    public void operation1() {
        System.out.println("B实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("B实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("B实现了operation5");
    }
}

class D implements Interface1{

    @Override
    public void operation1() {
        System.out.println("D实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("D实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("D实现了operation3");
    }

    @Override
    public void operation4() {
        System.out.println("D实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D实现了operation5");
    }
}

class A{//A类通过接口依赖（使用）B类，但是只会用到1,2,3方法
    public void depend1(Interface1 i){
      i.operation1();
    }

    public void depend2(Interface1 i){
        i.operation2();
    }

    public void depend3(Interface1 i){
        i.operation3();
    }
}

class C{//C类通过接口依赖（使用）B类，但是只会用到1,4,5方法
    public void depend1(Interface1 i){
        i.operation1();
    }

    public void depend4(Interface1 i){
        i.operation4();
    }

    public void depend5(Interface1 i){
        i.operation5();
    }
}



