package com.spdb.study.design.pattern.chain.auth.builderchain;

/**
 * @author Mr.Longyx
 * @date 2020年07月10日 22:40
 */
public class Test {
    public static void main(String[] args) {
        UserService service = new UserService();
        service.login("cafebabe","hadoop");
    }
}
