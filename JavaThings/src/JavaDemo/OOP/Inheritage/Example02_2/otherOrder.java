package JavaDemo.OOP.Inheritage.Example02_2;

import JavaDemo.OOP.Inheritage.Example02.Order;

public class otherOrder {
    public static void main(String[] args) {
        Order order = new Order();

        /*
        order.orderProtected = -3;      //error
         */
        order.orderPublic = -4;
        order.methodPublic();
    }

    public void show(Order order) {
        order.orderPublic = -5;
    }
}
