package com.spdb.study.design.principle.segregation.isolation;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 15:29
 */
public class Dog implements EatAnimation, PlayAnimation, SwimAnimation {
    @Override
    public void eat() {}

    @Override
    public void play() {}

    @Override
    public void swim() {}
}
