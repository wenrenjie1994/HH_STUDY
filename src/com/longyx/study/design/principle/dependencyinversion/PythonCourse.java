package com.spdb.study.design.principle.dependencyinversion;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 12:46
 */
public class PythonCourse implements Course {
    @Override
    public void study() {
        System.out.println("龙远栩正在学习Python课程");
    }
}
