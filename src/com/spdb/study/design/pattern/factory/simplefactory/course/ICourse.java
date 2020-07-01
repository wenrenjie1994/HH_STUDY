package com.spdb.study.design.pattern.factory.simplefactory.course;

/**
 * 简单工厂
 * 优点：只需要传入一个正确的参数，便可获得你想要的结果
 * 缺点：逻辑可能会复杂 可能会嵌套很多if...else...  工厂类的职责过重，有新产品时得修改工厂类的判断，违背开闭原则
 * 选课接口类
 * @author Mr.Longyx
 * @date 2020年06月21日 13:35
 */
public interface ICourse {
    void getCourse();
}
