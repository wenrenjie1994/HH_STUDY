package com.spdb.study.design.pattern.visitor.park;

/**
 * @author Mr.Longyx
 * @date 2020年07月13日 10:29
 */
public interface Visitor {
    void visit(Park park);
    void visit(ParkA parkA);
    void visit(ParkB parkB);
}
