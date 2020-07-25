package JavaDemo.OOP.Inheritage.Example01;

import JavaDemo.OOP.Inheritage.Example01.Person;
import JavaDemo.OOP.Inheritage.Example01.Student;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Zixian", 511011, 23);
        Student s1 = new Student("Chenglong", 511011, 23,
                "computer science", 16060301);

        p1.work();
        p1.info();

        s1.work();
        s1.info();
        s1.show();

        System.out.println("-------------");
        Student s2 = new Student();
    }
}
