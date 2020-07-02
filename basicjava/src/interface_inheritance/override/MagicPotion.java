package interface_inheritance.override;

//设计一个类MagicPotion 蓝瓶，继承Item, 重写effect方法
//        并输出 “蓝瓶使用后，可以回魔法”
public class MagicPotion extends Item{
    public void effect(){
        System.out.println("蓝瓶使用后，可以回魔法");
    }

    public static void main(String[] args) {
        Item i = new Item();
        i.effect();

        MagicPotion mp = new MagicPotion();
        mp.effect();
    }
}
