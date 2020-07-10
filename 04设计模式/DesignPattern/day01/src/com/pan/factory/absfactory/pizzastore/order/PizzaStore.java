package com.pan.factory.absfactory.pizzastore.order;

public class PizzaStore {
    public static void main(String[] args) {
//        new OrderPizza(new BJFactory());
        new OrderPizza(new LDFactory());
    }
}
