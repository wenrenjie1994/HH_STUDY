package charactor;

public class ADHero extends Hero implements AD, Mortal {
    // attack方法的重载
    public void attack() {
        System.out.println(name + "进行了一次攻击，但是不确定打中谁了");
    }

    // public void attack(Hero h1) {
    // System.out.println(name + "对" + h1.name +"进行了一次攻击");
    // }

    // public void attack(Hero h1, Hero h2) {
    // System.out.println(name + "同时对" + h1.name + "和" + h2.name + "进行了攻击 ");
    // }

    // 多参数方法，可采用可变数量的参数
    public void attack(Hero... heros) {
        for (int i = 0; i < heros.length; i++) {
            System.out.println(name + "攻击了" + heros[i].name);
        }
    }

    @Override
    public void physicAttack() {
        // TODO Auto-generated method stub
        System.out.println("发起了一次物理攻击");
    }

    @Override
    public void die() {
        System.out.println("ADHero死亡");
    }
    
    public static void battleWin() {
        System.out.println("adhero battle win");
    }

    public static void main(String[] args) {
        // ADHero bh = new ADHero();
        // bh.name = "赏金猎人";

        // Hero h1 = new Hero();
        // h1.name = "盖伦";
        // Hero h2 = new Hero();
        // h2.name = "提莫";

        // bh.attack(h1);
        // bh.attack(h1, h2);

        // Hero.battleWin();
        // ADHero.battleWin();

        // Hero h = new ADHero();
        // h.battleWin();//仍然会调用hero类的方法，只和h的类型有关系
    }
}