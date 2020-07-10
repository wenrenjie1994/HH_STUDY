package com.pan.builder.improve;

//抽象的建造者
public abstract class HouseBuilder {
    protected House house = new House();
    //建造的流程打地基
    public abstract void buildBasic();
    //砌墙
    public abstract void buildWalls();
    //封顶
    public abstract void roofed();

    //建造房子好后，将房子（产品）返回
    public House buildHouse(){
//        buildBasic();
//        buildWalls();
//        roofed();
        return house;
    }
}
