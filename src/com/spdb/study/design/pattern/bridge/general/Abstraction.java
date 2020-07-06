package com.spdb.study.design.pattern.bridge.general;

/**
 * 桥接模式（JDBC中DriverManager使用桥接模式连接了java.sql维度和各大数据库维度(如MySQL))
* 1、分离抽象部分及其具体实现部分
 * 2、提高了系统的扩展性
 * 3、符合开闭原则
 * 4、符合合成复用原则
 * 缺点：
 * 1、增加了系统的理解与设计难度
 * 2、需要正确地识别系统中的两个维度
 * @author Mr.Longyx
 * 抽象
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation() {
        this.implementor.operationImpl();
    }
}