package com.spdb.study.design.pattern.chain.auth.optimizer;

import com.spdb.study.design.pattern.chain.auth.old.User;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 21:56
 */
public class UserService {
    public void login(String username, String password){
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();

        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);

        validateHandler.doHandler(new User(username,password));
    }
}
