package charactor1;
import charactor.Hero;
//不同包里面的类，必须public的属性才能被访问到

public class Support extends Hero implements Healer {
    
    public void heal() {
        System.out.println(name + "随机治疗了一名友方英雄");
    }

    public void heal(Hero h) {
        System.out.println(name + "治疗了" + h.name);
    }

    public void heal(Hero h,int hp) {
        System.out.println(name + "为" + h.name + "治疗了" + hp + "滴血");
    }

    public static void main(String[] args) {
        Support s = new Support();
        s.name = "众星之子";
        Hero h = new Hero();
        h.name = "提莫";

        s.heal();
        s.heal(h);
        s.heal(h,50);
    }

    @Override
    public void hearl() {
        // TODO Auto-generated method stub
        System.out.println("进行了治疗");
    }
}