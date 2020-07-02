package class_object.extend;

public class Item {
    String name; //名字
    int price; //价格

    public static void main(String[] args){
        //血瓶
        Item xueping = new Item();
        xueping.name = "血瓶";
        xueping.price = 50;
        //草鞋
        Item caoxie = new Item();
        caoxie.name = "草鞋";
        caoxie.price = 300;
        //长剑
        Item changjian = new Item();
        changjian.name = "长剑";
        changjian.price = 350;
    }
}
