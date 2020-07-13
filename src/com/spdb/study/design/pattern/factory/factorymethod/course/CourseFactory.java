package com.spdb.study.design.pattern.factory.factorymethod.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.Course;

/**
 * 工厂方法顶层接口(解决产品链越来越多，逻辑变得越来越复杂的问题)
 * @author Mr.Longyx
 * @date 2020年06月21日 15:30
 */
public abstract class CourseFactory {
    public void preHandle(){}
    abstract Course create();
}
