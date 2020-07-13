package com.spdb.study.design.pattern.visitor.park;

/**
 * 公园每一部分的抽象
 * @author Mr.Longyx
 * @date 2020年07月13日 10:24
 */
public interface ParkElement {
    /**
     * 提供接纳访问者的方法
     * @author Mr.Longyx
     * @date 2020/7/13 10:25
     */
    void accept(Visitor visitor);
}
