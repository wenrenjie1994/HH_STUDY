package com.spdb.study.design.pattern.factory.factorymethod.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;

/**
 * 工厂方法模式：不同的产品用不同的工厂去创建，不同的工厂负责差异化的创建逻辑
 * 有利于在不改变原有逻辑的情况下，以新增类的方式去实现
 * 优点：加入新产品符合开闭原则，提高了系统的可扩展性
 * 缺点：类的个数容易过多，增加了代码结构的复杂度
 * @author Mr.Longyx
 * @date 2020年06月21日 15:45
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.getCourse();
    }
}
