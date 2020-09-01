package com.spdb.study.design.pattern.state.general.apply;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 18:21
 */
public class ConcreteStateA extends State{
    @Override
    public void handle() {
        System.out.println("处理状态A");
        /**
         * 状态A完成后自动切换到状态B
         * @author Mr.Longyx
         * @date 2020/7/11 19:53
         */
        this.context.setState(Context.B);
        this.context.getState().handle();
    }
}
