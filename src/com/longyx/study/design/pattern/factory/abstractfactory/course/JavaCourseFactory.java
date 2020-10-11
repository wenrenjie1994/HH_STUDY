package com.longyx.study.design.pattern.factory.abstractfactory.course;

import com.longyx.study.design.pattern.factory.simplefactory.course.Course;
import com.longyx.study.design.pattern.factory.simplefactory.course.JavaCourse;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 17:01
 */
public class JavaCourseFactory implements CourseFactory {

    @Override
    public Course createCourse() {
        return new JavaCourse();
    }

    @Override
    public Note createNote() {
        return new JavaNote();
    }

    @Override
    public Score createScore() {
        return new JavaScore();
    }
}
