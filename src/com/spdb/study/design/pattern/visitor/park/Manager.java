package com.spdb.study.design.pattern.visitor.park;

/**
 * 管理员 负责查看整片公园卫生情况
 * @author Mr.Longyx
 * @date 2020年07月13日 10:36
 */
public class Manager implements Visitor{
    @Override
    public void visit(Park park) {
        System.out.println("管理员负责"+park.getName()+"卫生检查");
    }

    @Override
    public void visit(ParkA parkA) {
        System.out.println("管理员检查"+parkA.getName()+"卫生");
    }

    @Override
    public void visit(ParkB parkB) {
        System.out.println("管理员检查"+parkB.getName()+"卫生");
    }
}
