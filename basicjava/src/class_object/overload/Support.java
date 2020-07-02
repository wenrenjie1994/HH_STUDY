package class_object.overload;

//设计一个类Support (辅助英雄)继承Hero，提供一个heal(治疗)方法
//        对Support的heal方法进行重载
//        heal()
//        heal(Hero h) //为指定的英雄加血
//        heal(Hero h, int hp) //为指定的英雄加了hp的血

import class_object.reference.Hero;

public class Support extends Hero {
    public void heal(){
        System.out.println("恢复血量");
    }

    public void heal(Hero h){
        System.out.println("为" + h.getName() + "恢复血量");
    }

    public void heal(Hero h, int hp){
        System.out.println("为" + h.getName() + "恢复" + hp + "的血量");
    }

    public static void main(String[] args) {
        Support support = new Support();
        support.setName("赏金猎人");

        Hero h = new Hero();
        h.setName("盖伦");

        support.heal(h);
        support.heal(h, 30);
    }
}
