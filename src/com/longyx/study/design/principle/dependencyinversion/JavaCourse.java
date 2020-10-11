package com.longyx.study.design.principle.dependencyinversion;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 12:45
 */
public class JavaCourse implements Course {
    @Override
    public void study() {
        System.out.println("龙远栩正在学习Java课程");
    }
}
