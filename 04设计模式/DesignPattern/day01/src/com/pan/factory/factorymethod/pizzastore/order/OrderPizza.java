package com.pan.factory.factorymethod.pizzastore.order;

import com.pan.factory.simplefactory.pizzastore.order.SimpleFactory;
import com.pan.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.pan.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.pan.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.pan.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OrderPizza {

    //定义一个抽象方法，creatPizza，让各个工厂子类自己实现
    abstract Pizza creatPizza(String orderType);

    //构造器
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;//订购披萨的类型
        do {
            orderType = gettype();
            pizza = creatPizza(orderType);//抽象方法，由工厂子类实现
            //输出披萨的制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);
    }

    //写一个方法获取客户订购披萨的类型
    private String gettype() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza type:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
