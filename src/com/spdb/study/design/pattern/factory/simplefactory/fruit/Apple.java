package com.spdb.study.design.pattern.factory.simplefactory.fruit;

/**
 * 苹果类
 * @author Mr.Longyx
 * @date 2020年06月21日 14:44
 */
public class Apple implements Fruit {

    @Override
    public void collect() {
        System.out.println("采集苹果");
    }
}
