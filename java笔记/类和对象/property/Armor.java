package property;
public class Armor extends Item {
    int ac;//护甲等级

    public static void main(String[] args) {
        Armor bujia = new Armor();
        bujia.name = "布甲";
        bujia.price = 300;
        bujia.ac = 15;

        Armor suozijia = new Armor();
        suozijia.name = "锁子甲";
        suozijia.price = 500;
        suozijia.ac = 40;
    }
}