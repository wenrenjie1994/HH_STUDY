package com.spdb.study.design.pattern.template.course;

/**
 * @author Mr.Longyx
 * @date 2020年06月29日 17:18
 */
public class JavaCourse extends NetworkCourse {
    @Override
    protected void checkHomeWork() {
        System.out.println("检查Java课程的课后作业");
    }
}
