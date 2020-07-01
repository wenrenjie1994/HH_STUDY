package com.spdb.study.design.pattern.factory.abstractfactory.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;
import com.spdb.study.design.pattern.factory.simplefactory.course.JavaCourse;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 17:01
 */
public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IScore createScore() {
        return new JavaScore();
    }
}
