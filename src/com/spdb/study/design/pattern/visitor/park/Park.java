package com.spdb.study.design.pattern.visitor.park;

import java.io.Serializable;

/**
 * @author Mr.Longyx
 * @date 2020年07月13日 10:30
 */
public class Park implements ParkElement, Serializable {
    private static final long serialVersionUID = 8107674044813796271L;

    /**
     * 持有各公园的引用
     * @author Mr.Longyx
     * @date 2020/7/13 10:30
     * @param visitor
     */
    private ParkA parkA;
    private ParkB parkB;

    private String name;

    public Park() {
        this.parkA = new ParkA();
        this.parkB = new ParkB();
        parkA.setName("公园A");
        parkB.setName("公园B");
    }

    public ParkA getParkA() {
        return parkA;
    }

    public void setParkA(ParkA parkA) {
        this.parkA = parkA;
    }

    public ParkB getParkB() {
        return parkB;
    }

    public void setParkB(ParkB parkB) {
        this.parkB = parkB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        parkA.accept(visitor);
        parkB.accept(visitor);
    }
}
