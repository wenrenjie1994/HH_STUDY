package com.spdb.study.design.pattern.visitor.park;

/**
 * 公园B
 * @author Mr.Longyx
 * @date 2020年07月13日 10:27
 */
public class ParkB implements ParkElement {
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
