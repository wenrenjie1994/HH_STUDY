package com.spdb.study.design.principle.responsibility.interfaced;

/**
 * 此接口不符合单一职责原则
 * @author Mr.Longyx
 * @date 2020年06月17日 14:33
 */
public interface ICourse {
    String getCourseName();
    byte[] getCourseView();

    void studyCourse();
    void refundCourse();
}
