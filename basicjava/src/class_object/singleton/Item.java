package class_object.singleton;

//使用懒汉式单例模式，把Item类改造成为单例模式

public class Item {
    private Item(){}
    private static Item instance;
    public static Item getInstance(){
        if (instance==null){
            instance = new Item();
        }
        return instance;
    }

    public static void main(String[] args) {
        Item t1 = Item.getInstance();
        Item t2 = Item.getInstance();
        Item t3 = Item.getInstance();

        System.out.println(t1==t2);
        System.out.println(t1==t3);
    }
}
