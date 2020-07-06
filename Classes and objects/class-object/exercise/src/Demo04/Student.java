package Demo04;
/*
定义一个标准的类
1：private:成员变量修饰
2.为每一个成员变量编写setget方法
3.编写一个无参数构造方法
4.编写一个全参数构造方法
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

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
