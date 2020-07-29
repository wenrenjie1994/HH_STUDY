package demo05;

public class Hero {
    private String name;//英雄的名字
    private int age;//英雄的年龄
    private  Weapon weapon;//英雄的武器

    public Hero(String name, int age, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
    }

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack(){
        System.out.println("年龄为"+this.age+"的"+this.name+"用"+this.weapon.getNickname()+"攻击敌方");
    }

}
