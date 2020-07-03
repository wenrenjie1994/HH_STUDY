package interface_inheritance.object;

//重写Item的 toString(), finalize()和equals()方法
//        toString() 返回Item的name + price
//        finalize() 输出当前对象正在被回收
//        equals(Object o) 首先判断o是否是Item类型，然后比较两个Item的price是否相同

public class Item {
    String name;
    int price;
    public String toString(){
        return name + ":" + price;
    }

    public void finalize(){
        System.out.println("当前对象正在被回收");
    }

    public boolean equals(Object o){
        if (o instanceof Item){
            Item i = (Item) o;
            return this.price == i.price;
        }
        return false;
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.name = "血瓶";
        item.price = 350;

        //测试toString()
        System.out.println(item.toString());
        //测试finalize()
        for (int i=0; i<10; i++){
            item.finalize();
        }
        //测试equals()
        System.out.println(item.equals(item));
    }
}
