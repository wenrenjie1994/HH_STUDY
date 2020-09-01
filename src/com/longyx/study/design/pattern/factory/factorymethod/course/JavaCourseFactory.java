package com.spdb.study.design.pattern.factory.factorymethod.course;


import com.spdb.study.design.pattern.factory.simplefactory.course.Course;
import com.spdb.study.design.pattern.factory.simplefactory.course.JavaCourse;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 15:36
 */
public class JavaCourseFactory extends CourseFactory {

    @Override
    public Course create() {
        return new JavaCourse();
    }
}
