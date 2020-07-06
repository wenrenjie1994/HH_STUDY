package demo01;

public class Demo01Phone {
    public static void main(String[] args) {
        Phone phone =new Phone();
        System.out.println(phone.brand);
        System.out.println(phone.price);
        System.out.println(phone.color);
        System.out.println("=======");
        phone.brand="苹果";
        phone.price=8388.0;
        phone.color="黑色";
        System.out.println(phone.brand);
        System.out.println(phone.price);
        System.out.println(phone.color);
        System.out.println("==================");
        phone.call("乔布斯");
        phone.sendMessage();

    }
}
