package com.pan.decorator;

//具体的decorator 这里就是调味品
public class Chocolate extends Decorator{
    public Chocolate(Drink obj) {
        super(obj);
        setDes("巧克力");
        setPrice(3.0f);//调味品的价格
    }
}
