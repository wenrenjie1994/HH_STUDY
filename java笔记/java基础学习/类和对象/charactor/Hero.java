package charactor;
//创建一个Hero类

//Weapon在其他包里，必须使用import
import property.Weapon;
import property.Item;
import property.LifePotion;
import property.MagicPotion;

public class Hero {
    public String name;
    public float hp;
    public float armor;
    public int moveSpeed;

    // 构造方法和类名一样
    // 并且没有返回类型
    // public Hero() {
    // // System.out.println("实例化一个对象的时候，必然会调用构造方法");
    // }

    // 这个无参的构造方法，如果不写，就会默认提供一个
    public Hero() {

    }
    // 一旦提供了一个有参的构造方法，同时没有显式提供一个无参的方法，那默认的无参方法就没有了
    // 构造方法也可以重载
    // public Hero(String heroName) {
    // name = heroName;
    // }

    // public Hero(String heroName, float heroHp) {
    // name = heroName;
    // hp = heroHp;
    // }

    // public Hero(String heroName, float heroHp, float heroArmor, int
    // heroMoveSpeed) {
    // name = heroName;
    // hp = heroHp;
    // armor = heroArmor;
    // moveSpeed = heroMoveSpeed;
    // }

    // this关键字打印内存中的虚拟地址
    public void showAddressInMemory() {
        System.out.println("打印this看到的虚拟地址：" + this);
    }

    // 使用this访问属性
    public void setName(String name) {
        this.name = name;
    }

    // 使用this调用其他的构造方法
    // 带一个参数的构造方法
    public Hero(String name) {
        // System.out.println("一个参数的构造方法");
        this.name = name;
    }

    // 带两个参数的构造方法
    public Hero(String name, float hp) {
        this(name);
        // System.out.println("两个参数的构造方法");
        this.hp = hp;
    }

    // 练习：带四个参数的构造方法
    public Hero(String name, float hp, float armor, int moveSpeed) {
        this(name, hp);
        this.armor = armor;
        this.moveSpeed = moveSpeed;
    }

    // 基本类型传参（回血）
    public void huixue(int xp) {
        hp += xp;
        xp = 0;
    }

    // 传参练习
    public void revive(Hero h) {
        h = new Hero("提莫", 383);
    }

    // 装备一把武器
    public void equip(Weapon weapon) {

    }

    // 使用物品
    public void useItem(Item i) {
        i.effect();
    }

    // 杀死英雄
    public void kill(Mortal m) {
        m.die();
    }

    // 类方法，静态方法
    // 通过类就可以直接调用
    public static void battleWin() {
        System.out.println("hero battle win");
    }

    // 所有类都继承Object类，自带一个toString方法
    public String toString() {
        return name;
    }

    // 使用equals()判断两个对象的类容是否相同
    public boolean equals(Object o) {
        if (o instanceof Hero) {
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }

    // finalize()当它被垃圾回收的时候，就会被调用
    public void finalize() {
        System.out.println("这个英雄正在被回收");
    }

    // 非静态内部类，只有一个外部类对象存在的时候，才有意义
    // 战斗成绩只有在一个英雄对象存在的时候才有意义
    class BattleScore {
        int kill;
        int die;
        int assit;

        public void legendary() {
            if (kill >= 8)
                System.out.println(name + "超神！");
            else
                System.out.println(name + "尚未超神！");
        }
    }

    public static void main(String[] args) {
        // 创建一个对象
        // new Hero();

        // 使用一个引用来指向这个对象
        // Hero h = new Hero();

        // 多个引用可以指向同一个对象
        // Hero h1 = new Hero();
        // Hero h2 = h1;
        // Hero h3 = h1;
        // Hero h4 = h1;
        // Hero h5 = h4;

        // 一个引用同一时间只能指向一个对象
        // Hero garen = new Hero();
        // garen = new Hero();

        // Hero h = new Hero();
        // Hero garen = new Hero("盖伦");
        // Hero teemo = new Hero("提莫",383);

        // Hero garen = new Hero();
        // garen.name = "盖伦";
        // System.out.println("打印对象看到的虚拟地址：" + garen);
        // garen.showAddressInMemory();

        // Hero teemo = new Hero();
        // teemo.name = "提莫";
        // System.out.println("打印对象看到的虚拟地址：" + teemo);
        // teemo.showAddressInMemory();

        // Hero teemo = new Hero("提莫", 383);
        // // int xueping = 100;
        // // teemo.huixue(xueping);
        // // System.out.println(xueping);//血瓶依旧是100
        // teemo.hp -= 400;
        // teemo.revive(teemo);
        // System.out.println(teemo.hp);// -17

        // Hero garen = new Hero();
        // garen.name = "盖伦";

        // // LifePotion lp = new LifePotion();
        // // MagicPotion mp = new MagicPotion();

        // // garen.useItem(lp);
        // // garen.useItem(mp);

        // ADHero ad = new ADHero();
        // APHero ap = new APHero();
        // ADAPHero adap = new ADAPHero();

        // garen.kill(ad);
        // garen.kill(ap);
        // garen.kill(adap);

        // Hero h = new Hero();
        // h.name = "盖伦";
        // System.out.println(h.toString());
        // System.out.println(h);

        // Hero h1 = new Hero();
        // h1.hp = 300;
        // Hero h2 = new Hero();
        // h2.hp = 400;
        // Hero h3 = new Hero();
        // h3.hp = 300;

        // System.out.println(h1.equals(h2));
        // System.out.println(h1.equals(h3));

        Hero garen = new Hero();
        garen.name = "盖伦";
        // 实例化内部类
        // BattleScore对象只有在一个英雄对象存在的时候才有意义
        // 所以其实例化必须建立在一个外部类对象的基础之上
        BattleScore score = garen.new BattleScore();
        score.kill = 9;
        score.legendary();
    }
}