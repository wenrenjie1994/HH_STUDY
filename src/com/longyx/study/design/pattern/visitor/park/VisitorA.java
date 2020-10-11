package com.longyx.study.design.pattern.visitor.park;

/**
 * 清洁工A 负责parkA的卫生情况
 * @author Mr.Longyx
 * @date 2020年07月13日 10:33
 */
public class VisitorA implements Visitor{
    @Override
    public void visit(Park park) {

    }

    @Override
    public void visit(ParkA parkA) {
        System.out.println("清洁工A负责打扫 "+parkA.getName()+"的卫生");
    }

    @Override
    public void visit(ParkB parkB) {

    }
}
