package com.longyx.study.design.pattern.mediator.general;

/**
 * 抽象同事类
 * @author Mr.Longyx
 * @date 2020年07月12日 11:20
 */
public abstract class Colleague {
    protected Meditor mediator;

    public Colleague(Meditor mediator) {
        this.mediator = mediator;
    }
}
