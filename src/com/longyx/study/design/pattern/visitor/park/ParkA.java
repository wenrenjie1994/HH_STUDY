package com.longyx.study.design.pattern.visitor.park;

/**
 * 公园A
 * @author Mr.Longyx
 * @date 2020年07月13日 10:26
 */
public class ParkA implements ParkElement {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
