package fu.day04.demo05;
/*
一个标准的类通常要拥有下面四个组成部分；
1.所有的成员变量都要使用private 关键字修饰
2.为每一个成员变量编写一对儿getter/setter 方法
3.编写一个无参的构造函数
4，编写一个全参数的构造函数

标准的类也叫做 Java Beam
 */
public class StandClass {
    private String name;
    private int age;

    public StandClass() {
    }
    public StandClass(String name, int age) {
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
