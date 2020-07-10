package com.pan.decorator;

public class CoffeeBar {
    public static void main(String[] args) {
        //装饰者模式下的订单：2份巧克力＋一份牛奶的long black

        //1.点一份long black
        Drink order = new LongBlack();
        System.out.println("费用1="+order.getPrice());
        System.out.println("描述1="+order.getDes());

        //2.加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入一份牛奶 费用 = "+order.cost());
        System.out.println("order 加入一份牛奶 描述 = "+order.getDes());

        //3.加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份牛奶 加入一份巧克力 费用 = "+order.cost());
        System.out.println("order 加入一份牛奶 加入一份巧克力 描述 = "+order.getDes());

        //4.再加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份牛奶 加入两份巧克力 费用 = "+order.cost());
        System.out.println("order 加入一份牛奶 加入两份巧克力 描述 = "+order.getDes());

        System.out.println("======================");
        //点一杯无因咖啡
        Drink order2 = new Decaf();
        System.out.println("order2 无因咖啡 费用 = "+order2.cost());
        System.out.println("order2 无因咖啡 描述 = "+order2.getDes());
        //无因咖啡加牛奶
        order2 = new Milk(order2);
        System.out.println("order2 无因咖啡 加入一份牛奶 费用 = "+order2.cost());
        System.out.println("order2 无因咖啡 加入一份牛奶 描述 = "+order2.getDes());
    }
}
