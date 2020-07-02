package class_object.extend;

//设计一个类Armor护甲
//        继承Item类，并且额外提供一个属性ac: 护甲等级 int类型
//
//        实例化出两件护甲
//        名称 价格 护甲等级
//        布甲 300 15
//        锁子甲 500 40
public class Armor extends Item{
    int ac; //护甲等级

    public static void main(String[] args) {
        Armor armor1 = new Armor();
        armor1.name = "布甲";
        armor1.price = 300;
        armor1.ac = 15;

        Armor armor2 = new Armor();
        armor2.name = "锁子甲";
        armor2.price = 500;
        armor2.ac = 40;
    }
}
