package com.spdb.study.design.pattern.state.zhihu;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 20:01
 */
public class UnLoginState extends UserState {
    @Override
    public void favorite() {
        this.checkLogin();
        this.context.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.checkLogin();
        this.context.getState().comment(comment);
    }

    private void checkLogin(){
        System.out.println("跳转至登录页");
        this.context.setState(this.context.LOGIN);
    }
}
