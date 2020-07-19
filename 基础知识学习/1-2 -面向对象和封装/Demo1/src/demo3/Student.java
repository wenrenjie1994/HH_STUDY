package demo3;

/**
 * 一个标准的类通常有四个组成部分:
 * 1.所有的成员变量都要使用private关键词修饰
 * 2.每个成员变量都编写一堆getter、setter
 * 3.编写一个无参的构造方法
 * 4.编写一个全参的构造方法
 *
 *
 */
public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
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
}
