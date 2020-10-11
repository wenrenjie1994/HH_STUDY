package com.longyx.study.design.pattern.visitor.dispatch.dynamicdispatch;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:47
 */
public class Main {
    public static void main(String[] args) {
        Person boy = new Boy();
        Person girl = new Girl();

        boy.test();
        girl.test();
    }
}
