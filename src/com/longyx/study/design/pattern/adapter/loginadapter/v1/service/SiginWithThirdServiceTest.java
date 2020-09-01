package com.spdb.study.design.pattern.adapter.loginadapter.v1.service;

/**
 * @author Mr.Longyx
 * @date 2020年07月02日 16:38
 */
public class SiginWithThirdServiceTest {
    public static void main(String[] args) {
        SiginWithThirdService service = new SiginWithThirdService();
        service.loginWithQQ("fhdjfhjsdkfawsdfk");
        service.login("joe","hadoop");
        service.loginWithTelephone("18398260768","63792");
    }
}
