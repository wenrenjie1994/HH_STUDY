package com.spdb.study.design.pattern.delegate.simple;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 16:03
 */
public class DelegateTest {
    public static void main(String[] args) {
        new Boss().task("通讯",new Leader());
    }
}
