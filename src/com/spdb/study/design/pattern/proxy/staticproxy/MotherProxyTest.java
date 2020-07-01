package com.spdb.study.design.pattern.proxy.staticproxy;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 20:35
 */
public class MotherProxyTest {
    public static void main(String[] args) {
        /**
         * 此为静态代理方式
         * @author Mr.Longyx
         * @date 2020/6/26 20:41
         */
        Mother mother = new Mother(new Son());
        mother.findLove();

    }
}
