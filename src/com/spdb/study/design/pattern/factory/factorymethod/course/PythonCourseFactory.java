package com.spdb.study.design.pattern.factory.factorymethod.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;
import com.spdb.study.design.pattern.factory.simplefactory.course.PythonCourse;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 15:44
 */
public class PythonCourseFactory extends ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
