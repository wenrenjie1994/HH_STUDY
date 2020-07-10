package com.pan.factory.factorymethod.pizzastore.order;

import com.pan.factory.factorymethod.pizzastore.pizza.*;

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza creatPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
