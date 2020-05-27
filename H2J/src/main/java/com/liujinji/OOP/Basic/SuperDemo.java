package com.liujinji.OOP.Basic;

public class SuperDemo extends Hero{
    public SuperDemo(String name, int health, int level) {
        // 子类使用父类构造器
        super(name, health, level);
    }


    public int getSuperHeroHealth() {
        // 子类调用父类方法
        return super.getHealth();
    }
}
