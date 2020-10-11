package com.longyx.study.design.pattern.facade.general;

/**
 * 门面模式通用实现方式
 * 门面模式适用场景：
 * 1、子系统越来越复杂，增加门面模式提供简单接口
 * 2、构建多层系统结构，利用门面模式对象作为每层的入口，简化层间调用
 * 优点：
 *1、简化了调用过程，无需深入了解子系统，以防给子系统带来风险(如各种Util工具包便应用了门面模式)
 *2、减少系统依赖，松散耦合
 *3、更好地划分访问层次，提高了安全性(如Controller->Service->Dao)
 *4、遵循迪米特法则，即最少知道原则
 * 缺点：
 * 1、当增加子系统和扩展子系统行为时，可能容易带来未知风险
 * 2、不符合开闭原则
 * 3、某些情况下可能违背单一职责原则
 * @author Mr.Longyx
 * @date 2020年07月05日 18:24
 */
public class Facade {
    private SubSystemA systemA;
    private SubSystemB systemB;
    private SubSystemC systemC;

    public Facade(){
        systemA = new SubSystemA();
        systemB = new SubSystemB();
        systemC = new SubSystemC();
    }
    /**
     * 整合多个系统统一对外提供服务
     * @author Mr.Longyx
     * @date 2020/7/5 18:37
     */
    public void doService(){
        systemA.doA();
        systemB.doB();
        systemC.doC();
    }
}
