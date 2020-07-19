package JavaDemo.OOP.encapsulation;

public class AnimalTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.name = "daH";
        a.setLegs(4);

        a.eat();
        a.show();
    }

}

class Animal {
    String name;
    private int legs;

    //encapsulation
    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getLegs() {
        return legs;
    }

    public void eat() {
        System.out.println("grass!");
    }

    public void show() {
        System.out.println("name: " + name + ", legs: " + legs);
    }
}