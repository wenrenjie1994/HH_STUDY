package JavaDemo.OOP.Polymorphic.Example03;

public class Teacher extends Person {
    boolean isProfessor;

    public void work() {
        System.out.println("teaching!!!");
    }

    @Override
    public void eat() {
        System.out.println("eat deli");
    }

    @Override
    public void traffic() {
        System.out.println("bicycle!!");
    }
}
