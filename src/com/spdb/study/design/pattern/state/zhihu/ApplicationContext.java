package com.spdb.study.design.pattern.state.zhihu;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 19:57
 */
public class ApplicationContext {
    public final UserState LOGIN = new LoginState();
    public final UserState UNLOGIN = new UnLoginState();

    private UserState currentState = UNLOGIN;

    {
        LOGIN.setContext(this);
        UNLOGIN.setContext(this);
    }

    public void setState(UserState state){
        this.currentState = state;
        this.currentState.setContext(this);
    }

    public UserState getState(){
        return this.currentState;
    }

    public void favorite(){
        this.currentState.favorite();
    }

    public void comment(String comment){
        this.currentState.comment(comment);
    }
}
