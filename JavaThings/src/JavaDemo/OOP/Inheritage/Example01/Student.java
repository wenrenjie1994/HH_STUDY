package JavaDemo.OOP.Inheritage.Example01;

import JavaDemo.OOP.Inheritage.Example01.Person;

public class Student extends Person {
    private String major;
    int idCard;             //student number

    public Student() {

    }
    public Student(String name, int id, int age, String major, int idCard) {
        super(name, id, age);
        this.major = major;
        this.idCard = idCard;
    }

    @Override
    public void work() {
        System.out.println("Coding!\tEating!\tRelaxing!");
    }

    @Override
    public void eat() {
        System.out.println("eat more meat!!!");
    }

    @Override
    public String info() {
        System.out.println(this.toString());
        return null;
    }

    public void show() {
        System.out.println("name: " + super.getName() + "\nidentity card: " +
                super.getIdCard() + "\nstudent number: " + this.idCard);
    }
}
