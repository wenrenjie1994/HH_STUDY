package com.testHR.demo;

/**
 * @description: 子类
 * @author: zeng
 * @modified By:
 */
public class Zi extends Fu {
    public int fu = 10;
    @Override
    public void method() {
        System.out.println("子类的method:"+fu);
        System.out.println("子类的method:(super)"+super.fu);
    }
    public void methodFu(){
        System.out.println("子类的methodFu");
    }
}
