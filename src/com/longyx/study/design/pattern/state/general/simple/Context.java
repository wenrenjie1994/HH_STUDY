package com.spdb.study.design.pattern.state.general.simple;

/**
 * 环境类
 * @author Mr.Longyx
 * @date 2020年07月11日 17:52
 */
public class Context {
    private static final State A = new ConcreteStateA();
    private static final State B = new ConcreteStateB();

    /**
     * 默认状态
     * @author Mr.Longyx
     * @date 2020/7/11 17:58
     */
    private State currentState = A;

    public void setState(State state){
        this.currentState = state;
    }

    public void handle(){
        this.currentState.handle();
    }
}
