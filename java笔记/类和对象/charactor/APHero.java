package charactor;

public class APHero extends Hero implements AP, Mortal {

    @Override
    public void magicAttack() {
        System.out.println("发起了一次魔法攻击");
    }

    @Override
    public void die() {
        System.out.println("APHero死亡");
    }

}