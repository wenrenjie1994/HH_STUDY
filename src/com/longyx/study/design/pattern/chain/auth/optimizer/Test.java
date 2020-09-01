package com.spdb.study.design.pattern.chain.auth.optimizer;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 22:00
 */
public class Test {
    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.login("cafebabe", "hadoop");
    }
}
