package property;

//物品类Item
public class Item {
    String name;
    int price;

    public void buy() {
        System.out.println("购买");
    }

    public void effect() {
        System.out.println("物品使用后，可以有效果");
    }

    public String toString() {
        return this.name + "的价格是：" + this.price;
    }

    public void finalize(){
        System.out.println("当前对象正在被回收");
    }

    public boolean equals(Object o){
        if(o instanceof Item){
            Item i = (Item) o;
            return this.price == i.price;
        }
        return false;
    }

    public static void main(String[] args) {
        // Item i = new Item();
        // i.effect();

        // LifePotion lp = new LifePotion();
        // lp.effect();

        // MagicPotion mp = new MagicPotion();
        // mp.effect();

        // 多态
        // Item i1 = new LifePotion();
        // Item i2 = new MagicPotion();
        // i1.effect();
        // i2.effect();

    }

}