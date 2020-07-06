package com.spdb.study.design.pattern.bridge.general;

/**
 * @author Mr.Longyx
 */
// 修正抽象
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("refined operation");
    }
}