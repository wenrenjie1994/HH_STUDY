package com.longyx.study.design.pattern.state.general.simple;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 17:55
 */
public class ConcreteStateB implements State {
    @Override
    public void handle() {
        System.out.println("状态B");
    }
}
