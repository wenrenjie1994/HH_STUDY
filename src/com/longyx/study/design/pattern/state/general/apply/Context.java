package com.spdb.study.design.pattern.state.general.apply;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 18:22
 */
public class Context {
    protected static final State A = new ConcreteStateA();
    protected static final State B = new ConcreteStateB();

    private State defaultState = A;
    {
        A.setContext(this);
        B.setContext(this);
    }

    public void setState(State state){
        this.defaultState = state;
        this.defaultState.setContext(this);
    }

    public State getState(){
        return this.defaultState;
    }

    public void handle(){
        this.defaultState.handle();
    }
}
