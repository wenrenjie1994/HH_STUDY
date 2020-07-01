package com.spdb.study.design.principle.segregation.simple;

/**
 * 接口隔离原则：用多个专门的接口，而不是使用单一的总接口
 * 符合高内聚、低耦合的设计思想
 * 该接口不符合接口隔离原则
 * @author Mr.Longyx
 * @date 2020年06月17日 15:05
 */
public interface IAnimal {
    void eat();
    void fly();
    void swim();
    void play();
}
