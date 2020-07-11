package com.spdb.study.design.pattern.chain.auth.builderchain;

import com.spdb.study.design.pattern.chain.auth.old.User;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 21:55
 */
public class AuthHandler extends Handler {
    @Override
    public void doHandler(User user) {
        if (!"管理员".equals(user.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许进行下一步操作");
    }
}
