package demo05;
/*类作为成员变量类型*/
public class DemoMain {
    public static void main(String[] args) {
        //创建一个英雄角色
        Hero hero=new Hero();
        hero.setName("盖伦");
        hero.setAge(20);
        Weapon weapon=new Weapon("多兰剑");
        hero.setWeapon(weapon);
        hero.attack();
    }
}
