package interface_inheritance.polymorphic;

public class APHero implements Mortal{
    public void die(String name){
        System.out.println(name + "杀死了AP英雄");
    }
}
