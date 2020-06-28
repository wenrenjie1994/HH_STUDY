package ji_chen;

class Animal{
    private String name;
    private String action;
    public Animal(String animalName,String animalAction){
        name=animalName;
        action=animalAction;
    }
    public void describe(){
        System.out.println("Animal name: "+name);
        System.out.println("Animal action: "+action);
    }
}

class Cat extends Animal{
    public Cat(String catName,String catAction){
        super(catName,catAction);
    }
    public void describe(){
        System.out.println("cat eat fish");
    }
    public void descri(){
        super.describe();
        this.describe();
    }
}

class Dog extends Animal{
    public Dog(String dogName,String dogAction){
        super(dogName,dogAction);
    }
    public void describe(){
        System.out.println("dog not eat cat");
    }
    public void descri(){
        super.describe();
        this.describe();
    }
}

public class ji_chen {
    public static void main(String[] args){
        Animal Animal=new Animal("animal","do something");
        Cat cat=new Cat("ketty","fishing");
        Dog dog=new Dog("erha","playing with ketty");
        cat.descri();
        dog.descri();
    }
}
