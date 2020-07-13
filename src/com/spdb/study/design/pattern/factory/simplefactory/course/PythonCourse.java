package com.spdb.study.design.pattern.factory.simplefactory.course;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 14:14
 */
public class PythonCourse implements Course {
    @Override
    public void getCourse() {
        System.out.println("Python课程选课成功!");
    }
}
