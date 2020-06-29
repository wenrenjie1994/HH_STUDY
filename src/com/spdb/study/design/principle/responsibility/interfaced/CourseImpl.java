package com.spdb.study.design.principle.responsibility.interfaced;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 14:34
 */
public class CourseImpl implements ICourseInfo,ICourseManage{
    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseView() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
