package com.spdb.study.design.principle.dependencyinversion;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 12:49
 */
public class AICourse implements ICourse {
    @Override
    public void study() {
        System.out.println("龙远栩正在学习AI课程");
    }
}
