package com.spdb.study.design.pattern.chain.auth.builderchain;

import com.spdb.study.design.pattern.chain.auth.old.User;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 21:49
 */
public class LoginHandler extends Handler {

    @Override
    public void doHandler(User user) {
        System.out.println("登录成功！");
        user.setRoleName("管理员");
        this.next.doHandler(user);
    }
}
