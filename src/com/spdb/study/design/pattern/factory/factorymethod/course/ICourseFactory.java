package com.spdb.study.design.pattern.factory.factorymethod.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;

/**
 * 工厂方法顶层接口(解决产品链越来越多，逻辑变得越来越复杂的问题)
 * @author Mr.Longyx
 * @date 2020年06月21日 15:30
 */
public abstract class ICourseFactory {
    public void preHandle(){}
    abstract ICourse create();
}
