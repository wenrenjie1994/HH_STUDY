package com.spdb.study.design.pattern.factory.abstractfactory.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;

/**
 * 顶层工厂接口
 * 要求所有的子工厂都实现这个工厂
 * @author Mr.Longyx
 * @date 2020年06月21日 16:52
 */
public interface ICourseFactory {
    ICourse createCourse();
    INote createNote();
    IScore createScore();
}
