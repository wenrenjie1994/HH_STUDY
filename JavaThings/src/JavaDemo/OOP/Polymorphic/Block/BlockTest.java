package JavaDemo.OOP.Polymorphic.Block;

public class BlockTest {
    public static void main(String[] args) {
        String desc = Person.desc;
        System.out.println(desc);
        Person.info();

        Person p = new Person();
        System.out.println(p.age);
    }
}

class Person {
    {
        age = 2;
    }
    String name;
    int age = 3;
    static String desc = "hello world";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //code block
    static {
        System.out.println("static block!");
    }

    {
        System.out.println("non-static block!");
    }

    public void eat() {
        System.out.println("eat");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    public static void info() {
        System.out.println("ni hao, " + desc);
    }
}
