package com.pan.factory.absfactory.pizzastore.order;

import com.pan.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    AbsFactory factory;

    //构造器
    public OrderPizza(AbsFactory factory) {
        setFactory(factory);
    }


    private void setFactory(AbsFactory factory) {

        Pizza pizza = null;
        String orderType = ""; //用户输入的
        this.factory = factory;

        do {
            orderType = gettype();
            //factory可能是北京的工厂子类，也可能是伦敦的工况子类
            pizza = factory.creatPizza(orderType);

            //输出pizza
            if (pizza != null) {//订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("披萨订购失败");
                break;
            }

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
