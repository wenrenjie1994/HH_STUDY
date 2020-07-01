package com.spdb.study.design.pattern.factory.simplefactory.course;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 13:36
 */
public class JavaCourse implements ICourse {
    @Override
    public void getCourse() {
        System.out.println("Java课程选课成功！");
    }
}
