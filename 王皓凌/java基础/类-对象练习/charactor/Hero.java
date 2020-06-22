package charactor;
import property.Weapon;
public class Hero {
    String name;
    float hp;
    float armor;
    int MoveSpeed;
    static String copyright;//类属性
    public void equip(Weapon w){

    }
    public void die(){
        hp = 0;
    }
    public static void battleWin(){
        System.out.println("battle win");
    }
    public static void main(String[] args){
        Hero garen =  new Hero();
        garen.name = "盖伦";
        Hero.copyright = "版权由Riot Games公司所有";
        System.out.println(garen.name);
        System.out.println(garen.copyright);
        Hero.battleWin();
        ADHERO ad = new ADHERO();
        APHERO ap = new APHERO();

    }
}