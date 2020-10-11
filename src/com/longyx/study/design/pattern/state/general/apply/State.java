package com.longyx.study.design.pattern.state.general.apply;

/**
 * 抽象状态类 持有公共的行为
 * @author Mr.Longyx
 * @date 2020年07月11日 18:21
 */
public abstract class State {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handle();
}
