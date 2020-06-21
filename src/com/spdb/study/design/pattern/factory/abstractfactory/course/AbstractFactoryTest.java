package com.spdb.study.design.pattern.factory.abstractfactory.course;

/**
 * 解决产品链、产品族、产品等级结构非常复杂的情况 以及每一个产品的创建逻辑差异化程度非常高的情况
 * 抽象工厂不符合开闭原则
 * @author Mr.Longyx
 * @date 2020年06月21日 17:09
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        factory.createCourse().getCourse();
        factory.createNote();
        factory.createScore();

    }
}
