package com.pan.factory.simplefactory.pizzastore.order;

import com.pan.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza2 {

    Pizza pizza = null;
    String orderType;

    //构造器
    public OrderPizza2(){

        do{
            orderType = gettype();
            pizza = SimpleFactory.creatPizza2(orderType);

            //输出pizza
            if(pizza != null){//订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else{
                System.out.println("披萨订购失败");
            }

        }while (true);

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
