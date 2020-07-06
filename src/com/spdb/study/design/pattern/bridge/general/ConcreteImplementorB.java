package com.spdb.study.design.pattern.bridge.general;

/**
 * @author Mr.Longyx
 */
// 具体实现
public class ConcreteImplementorB implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("I'm ConcreteImplementor B");
    }
}