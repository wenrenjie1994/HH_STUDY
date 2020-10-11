package com.longyx.study.design.pattern.state.general.apply;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 18:22
 */
public class ConcreteStateB extends State{
    @Override
    public void handle() {
        System.out.println("处理状态B");
        /**
         * 此处为了避免两个状态来回切换导致程序崩溃
         * this.context.setState(Context.A);
         * this.context.getState().handle();
         * @author Mr.Longyx
         * @date 2020/7/11 22:05
         */
    }
}
