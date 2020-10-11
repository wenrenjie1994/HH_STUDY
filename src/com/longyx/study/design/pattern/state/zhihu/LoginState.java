package com.longyx.study.design.pattern.state.zhihu;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 19:59
 */
public class LoginState extends UserState{
    @Override
    public void favorite() {
        System.out.println("收藏成功");
    }

    @Override
    public void comment(String comment) {
        System.out.println("评论成功，内容："+comment);
    }
}
