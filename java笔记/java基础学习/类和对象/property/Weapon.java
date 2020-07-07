package property;
//不继承的写法
// public class Weapon {
//     // String name;
//     // int price;
//     // int damage;
// }

public class Weapon extends Item{
    int damage;//攻击力

    public static void main(String[] args) {
        Weapon infinityEdge = new Weapon();
        infinityEdge.damage = 65;
        //从Item类中继承了两个属性
        infinityEdge.name = "无尽之刃";
        infinityEdge.price = 3600;
    }
}
