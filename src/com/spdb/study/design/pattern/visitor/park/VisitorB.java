package com.spdb.study.design.pattern.visitor.park;

/**
 * 清洁工B 负责parkB的卫生情况
 * @author Mr.Longyx
 * @date 2020年07月13日 10:35
 */
public class VisitorB implements Visitor {
    @Override
    public void visit(Park park) {

    }

    @Override
    public void visit(ParkA parkA) {

    }

    @Override
    public void visit(ParkB parkB) {
        System.out.println("清洁工负责打扫 "+parkB.getName()+"的卫生");
    }
}
