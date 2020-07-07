package charactor;

public class ADAPHero extends Hero implements AD,AP,Mortal {

    @Override
    public void magicAttack() {
        // TODO Auto-generated method stub
        System.out.println("进行了魔法攻击");
    }

    @Override
    public void physicAttack() {
        // TODO Auto-generated method stub
        System.out.println("进行了物理攻击");
    }

    @Override
    public void die() {
        System.out.println("ADAPHero死亡");
    }
    
}