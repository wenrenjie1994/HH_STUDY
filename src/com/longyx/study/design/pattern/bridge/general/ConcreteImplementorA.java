package com.spdb.study.design.pattern.bridge.general;

/**
 * @author Mr.Longyx
 */
// 具体实现
public class ConcreteImplementorA implements Implementor {

    @Override
    public void operationImpl() {
        System.out.println("I'm ConcreteImplementor A");
    }
}