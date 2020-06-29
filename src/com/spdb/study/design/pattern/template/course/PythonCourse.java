package com.spdb.study.design.pattern.template.course;

/**
 * @author Mr.Longyx
 * @date 2020年06月29日 17:17
 */
public class PythonCourse extends NetworkCourse {
    private boolean flag = false;

    public PythonCourse(boolean flag) {
        this.flag = flag;
    }

    @Override
    protected void checkHomeWork() {
        System.out.println("检查Python全栈的课件");
    }

    @Override
    protected boolean needHomeWork() {
        return this.flag;
    }
}
