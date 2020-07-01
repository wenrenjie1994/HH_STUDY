package com.spdb.study.design.pattern.factory.abstractfactory.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 17:12
 */
public class PythonCourseFactory implements ICourseFactory{
    @Override
    public ICourse createCourse() {
        return null;
    }

    @Override
    public INote createNote() {
        return null;
    }

    @Override
    public IScore createScore() {
        return null;
    }
}
