package com.pan.decorator;

public class Decorator extends Drink{
    private Drink obj;

    public Decorator(Drink obj) {//组合的关系
        this.obj = obj;
    }

    @Override
    public float cost() {
        //getPrice()调料自己的价格
        return super.getPrice() + obj.getPrice();
    }

    @Override
    public String getDes() {
        //装饰者的描述＋装饰者的价格+被装饰者（组合的Drink）的描述
        return des + " " + getPrice() + " && " + obj.getDes();
    }
}
