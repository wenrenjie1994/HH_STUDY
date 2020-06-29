package com.spdb.study.design.pattern.factory.simplefactory.course;

import com.spdb.study.design.pattern.factory.simplefactory.course.ICourse;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 14:14
 */
public class PythonCourse implements ICourse {
    @Override
    public void getCourse() {
        System.out.println("Python课程选课成功!");
    }
}
