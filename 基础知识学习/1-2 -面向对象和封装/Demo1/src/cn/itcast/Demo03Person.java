package cn.itcast;

public class Demo03Person {
    public static void main(String[] args) {
        Person person = new Person();
        person.show();
        System.out.println("============");
        person.name="zhao";
        person.setAge(-20);
        person.show();
    }
}
