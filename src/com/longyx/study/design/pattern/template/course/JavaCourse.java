package com.longyx.study.design.pattern.template.course;

/**
 * @author Mr.Longyx
 * @date 2020年07月01日 13:42
 */
public class JavaCourse extends CourseTemplate {
    private  boolean needCheckHomeWork = false;

    public JavaCourse(boolean needCheckHomeWork) {
        this.needCheckHomeWork = needCheckHomeWork;
    }

    @Override
    protected void checkHomeWork() {
        System.out.println("批改Java课程作业");
    }

    @Override
    protected boolean needHomework() {
        return this.needCheckHomeWork;
    }
}
