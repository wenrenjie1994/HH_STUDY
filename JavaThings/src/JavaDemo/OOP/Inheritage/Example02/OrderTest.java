package JavaDemo.OOP.Inheritage.Example02;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();

        /*
        order.orderPrivate = -1;        //error
        order.methodPrivate();
         */
        order.orderDefault = -2;
        order.methodDefault();
    }

}
