package com.spdb.study.design.pattern.state.zhihu;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 19:47
 */
public abstract class UserState {
    protected ApplicationContext context;

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public abstract void favorite();
    public abstract void comment(String comment);
}
