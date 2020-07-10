package com.pan.factory.simplefactory.pizzastore.order;

import com.pan.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.pan.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.pan.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.pan.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    //构造器
//    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType;
//        do {
//            orderType = gettype();
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName("希腊披萨");
//            } else if (orderType.equals("cheese")) {
//                pizza = new CheesePizza();
//                pizza.setName("奶酪披萨");
//            } else if(orderType.equals("pepper")){
//                pizza = new PepperPizza();
//                pizza.setName("胡椒披萨");
//            }
//            else {
//                break;
//            }
//        //输出披萨的制作过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//
//        } while (true);


    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    //构造器
    public OrderPizza(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory){
        String orderType = ""; //用户输入的
        this.simpleFactory = simpleFactory;//设置简单工厂对象

        do{
            orderType = gettype();
            pizza = this.simpleFactory.creatPizza(orderType);

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
