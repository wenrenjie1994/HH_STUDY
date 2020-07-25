package JavaDemo.OOP.Inheritage.Example01;

public class Person {
    private String name;
    private int idCard;         //identity number
    private int age;

    public Person() {
        System.out.println("test");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int idCard, int age) {
        this.name = name;
        this.idCard = idCard;
        this.age = age;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getIdCard() {
        return idCard;
    }

    public int getAge() {
        return age;
    }

    public void work() {
        System.out.println("It's necessary!!");
    }
    public void eat() {
        System.out.println("cool!!!");
    }

    public Object info() {
        System.out.println(this.toString());
        return null;
    }
}
