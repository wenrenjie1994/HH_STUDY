package com.longyx.study.design.pattern.template.course;

/**
 * @author Mr.Longyx
 * @date 2020年07月01日 13:43
 */
public class PythonCourse extends CourseTemplate {
    @Override
    protected void checkHomeWork() {
        System.out.println("检查Python课程作业");
    }
}
