package com.longyx.study.design.pattern.visitor.dispatch.dynamicdispatch;

/**
 * 动态分派(在编译期间无法确定其类型，需要在运行期间才能确定调用哪个方法)
 * @author Mr.Longyx
 * @date 2020年07月12日 22:45
 */
public interface Person {
    void test();
}
