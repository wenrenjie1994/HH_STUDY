package interface_inheritance.abstractclass;

//有的物品使用之后就消失了，比如血瓶
//        有的物品使用了之后还会继续存在，比如武器
//        为Item类设计一个抽象方法
//        不同的子类，实现disposable后，会返回不同的值。
//        比如LifePotion就会返回true，因为是会消失了。
//        而Weapon就会返回false,因为是不会消失了

public abstract class Item {
    public abstract boolean disposable();

    public static void main(String[] args) {
        LifePotion lp = new LifePotion();
        System.out.println(lp.disposable());

        Weapon w = new Weapon();
        System.out.println(w.disposable());
    }
}
