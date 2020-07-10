package com.pan.factory.absfactory.pizzastore.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("北京奶酪披萨 准备原材料");
    }

}
