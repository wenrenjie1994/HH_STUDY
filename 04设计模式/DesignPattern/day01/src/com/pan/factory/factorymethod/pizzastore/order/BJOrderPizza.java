package com.pan.factory.factorymethod.pizzastore.order;

import com.pan.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.pan.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.pan.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.pan.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.pan.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza creatPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
