package com.longyx.study.design.pattern.visitor.general;

/**
 * 抽象元素
 * @author Mr.Longyx
 * @date 2020年07月12日 21:11
 */
public interface Element {
    void accept(Visitor visitor);
}
