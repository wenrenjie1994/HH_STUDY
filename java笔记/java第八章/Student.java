package basic.method.demo1.day4;

public class Student {
    private int id;
    private String name;
    private int age;
    static String room;
    private static int idCounter = 0;//学号计数器，每当new了一个对象，计数器++

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = ++idCounter;
    }

    public Student() {
        idCounter++;
    }


}
