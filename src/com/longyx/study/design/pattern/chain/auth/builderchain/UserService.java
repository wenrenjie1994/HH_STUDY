package com.longyx.study.design.pattern.chain.auth.builderchain;

import com.longyx.study.design.pattern.chain.auth.old.User;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 22:12
 */
public class UserService {
    public void login(String username, String password){
        Handler.Builder builder = new Handler.Builder<>();

        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());
        builder.build().doHandler(new User(username,password));
    }
}
