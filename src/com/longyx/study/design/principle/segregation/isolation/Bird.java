package com.longyx.study.design.principle.segregation.isolation;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 15:18
 */
public class Bird implements EatAnimation, FlyAnimation, SwimAnimation {
    @Override
    public void eat() {}

    @Override
    public void fly() {}

    @Override
    public void swim() {}
}
