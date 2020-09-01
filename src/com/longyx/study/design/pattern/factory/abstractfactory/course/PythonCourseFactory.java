package com.spdb.study.design.pattern.factory.abstractfactory.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.Course;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 17:12
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Course createCourse() {
        return null;
    }

    @Override
    public Note createNote() {
        return null;
    }

    @Override
    public Score createScore() {
        return null;
    }
}
