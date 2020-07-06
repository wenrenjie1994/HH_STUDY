package demo02;

public class Demo03Person {
    public static void main(String[] args) {
        Person person =new Person();
        person.show();
        person.name="Kobe";
        //person.age=18;
        person.setAge(-20);

        person.show();
    }
}
