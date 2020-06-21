package skill;
import charactor.Hero;
public class Cure extends Hero {
    public void heal(){
        System.out.println("对自己进行治疗");
    }
    public void heal(Hero hero){
        System.out.println("给英雄 " + hero + " 加血");
    }
    public void heal(Hero hero,int hp){
        System.out.println("给英雄 " + hero + " 加了 " + hp + "点血");
    }
}
