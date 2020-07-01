package BasicContents.ClassAndObject;

public class Item {
    
    // 名字
    public String name;
    // 价格
    public int price;

    public static void main(String[] args) {
        // 创建血瓶实例，并对其成员变量赋值
        Item item1 = new Item();
        item1.name = "血瓶";
        item1.price = 50;
        System.out.println(item1.name + "的价格是：" + item1.price);

        // 创建草鞋实例，并对其成员变量赋值
        Item item2 = new Item();
        item2.name = "草鞋";
        item2.price = 300;
        System.out.println(item2.name + "的价格是：" + item1.price);


        // 创建长剑实例，并对其成员变量赋值
        Item item3 = new Item();
        item3.name = "长剑";
        item3.price = 350;
        System.out.println(item3.name + "的价格是：" + item1.price);

    }
}