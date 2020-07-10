package com.pan.factory.absfactory.pizzastore.order;

import com.pan.factory.absfactory.pizzastore.pizza.Pizza;
import com.pan.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import com.pan.factory.absfactory.pizzastore.pizza.BJPepperPizza;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza creatPizza(String orderType) {
        System.out.println("使用的是抽象工厂模式！");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
