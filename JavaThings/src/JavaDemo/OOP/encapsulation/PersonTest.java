package JavaDemo.OOP.encapsulation;

//test class
public class PersonTest {
    public static void main(String[] args) {
        //establish
        Person p1 = new Person();

        //call
        p1.name = "ChenglLiu";
        p1.age = 23;
        p1.isStudent = false;

        System.out.println(p1.name);

        p1.eat();
        p1.code();
        p1.sleep();
        p1.speak("Chinese");

        Person p2 = new Person();
        System.out.println(p2.name);

        Person p3 = p1;              //it's address!!
        System.out.println(p1.name);
        p3.age = 18;                 //p1.age has changed!!
        System.out.println(p1.age);
    }
}

class Person {
    //filed
    String name;
    int age;
    boolean isStudent;

    //method
    public void eat() {
        System.out.println("meat!");
    }
    public void code() {
        System.out.println("yes!");
    }
    public void sleep() {
        System.out.println("oo!");
    }
    public void speak(String language) {
        System.out.println("The mother language is " + language);
    }
}