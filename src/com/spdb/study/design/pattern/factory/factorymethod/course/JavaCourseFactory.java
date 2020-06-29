package com.spdb.study.design.pattern.factory.factorymethod.course;


import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;
import com.spdb.study.design.pattern.factory.simplefactory.course.JavaCourse;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 15:36
 */
public class JavaCourseFactory extends ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
