package com.longyx.study.design.pattern.bridge.general;

/**
 * @author Mr.Longyx
 * @date 2020/7/6 15:05
 */
public class Test {
    public static void main(String[] args) {
        // 来一个实现化角色
        Implementor imp = new ConcreteImplementorA();
        // 来一个抽象化角色，聚合实现
        Abstraction abs = new RefinedAbstraction(imp);
        // 执行操作
        abs.operation();
    }
}
