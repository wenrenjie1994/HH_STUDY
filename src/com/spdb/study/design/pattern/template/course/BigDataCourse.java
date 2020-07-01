package com.spdb.study.design.pattern.template.course;

/**
 * @author Mr.Longyx
 * @date 2020年06月29日 17:19
 */
public class BigDataCourse extends NetworkCourse {

    private boolean needHomeWorkFlag = false;

    public BigDataCourse(boolean needHomeWorkFlag) {
        this.needHomeWorkFlag = needHomeWorkFlag;
    }

    @Override
    protected void checkHomeWork() {
        System.out.println("检查大数据课程课后作业");
    }

    @Override
    protected boolean needHomeWork() {
        return this.needHomeWorkFlag;
    }
}
