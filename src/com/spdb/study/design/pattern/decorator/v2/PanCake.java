package com.spdb.study.design.pattern.decorator.v2;

/**
 * 顶层设计 引入装饰者模式(抽象类)
 * 优点：
 * 1、装饰器是继承的有力补充，比继承灵活，不改变原有对象的情况下，动态的给一个对象扩展功能，即插即用
 * 2、通过使用不同装饰类以及这些装饰类的排列组合，可以实现不同的效果
 * 3、装饰者完全遵守开闭原则
 * 缺点：
 * 1、会出现更多的代码，更多的类，增加程序复杂性。
 * 2、动态装饰时，多层装饰时会更复杂
 * @author Mr.Longyx
 * @date 2020年07月03日 10:33
 */
public abstract class PanCake {
    protected abstract String getMsg(String food);
    protected abstract int getPrice(int price);
}
