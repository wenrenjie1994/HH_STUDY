package interface_inheritance.polymorphic;

public class ADHero implements Mortal{
    public void die(String name){
        System.out.println(name + "杀死了AD英雄");
    }
}
