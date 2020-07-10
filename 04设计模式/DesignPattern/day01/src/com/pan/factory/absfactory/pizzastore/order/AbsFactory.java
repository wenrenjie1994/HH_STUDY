package com.pan.factory.absfactory.pizzastore.order;

import com.pan.factory.absfactory.pizzastore.pizza.Pizza;

//抽象工厂模式的抽象层（接口）
public interface AbsFactory {
    //让下面的工厂子类来实现
    public Pizza creatPizza(String orderType);
}
