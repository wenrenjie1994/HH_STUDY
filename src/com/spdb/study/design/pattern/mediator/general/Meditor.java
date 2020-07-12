package com.spdb.study.design.pattern.mediator.general;

/**
 * 抽象中介者
 * 中介者模式适用场景：
 * 1、系统中对象之间存在复杂的引用关系，产生的相互依赖关系结构混乱且难以理解
 * 2、交互的公共行为，如果需要改变行为则可以增加新的中介者类
 * 优点：
 * 1、减少了类间依赖，将多对多依赖转化成了一对多，降低了类间耦合(例如RPC、注册中心等都是应用了中介者模式的体现)
 * 2、类间各司其职，符合迪米特法则
 * 缺点：
 * 1、中介者模式中将原本多个对象直接的相互依赖变成了中介者和多个同事类的依赖关系。当同事类越多时，中介者就会越臃肿，变得复杂且难以维护
 * @author Mr.Longyx
 * @date 2020年07月12日 11:16
 */
public abstract class Meditor {
    protected ConcreteColleagueA colleagueA;
    protected ConcreteColleagueB colleagueB;

    public void setColleagueA(ConcreteColleagueA colleague){
        this.colleagueA = colleague;
    }

    public void setColleagueB(ConcreteColleagueB colleague){
        this.colleagueB = colleague;
    }

    /**
     * 中介者业务逻辑
     * @author Mr.Longyx
     * @date 2020/7/12 12:42
     */
    public abstract void transferA();

    public abstract void transferB();
}
