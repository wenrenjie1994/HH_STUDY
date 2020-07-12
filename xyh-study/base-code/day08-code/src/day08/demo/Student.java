package day08.demo;

public class Student {
    //姓名
    private String name;
    //年龄
    private int age;
    //所在教室(同班同学);
    private int id;

    static String room;
    //计数器
    private static int idCounter=0;//学号计数器，每当创建新对象时，计数器++
    //无参构造
    public Student(){
        idCounter++;
    }
    //有参构造
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id=++idCounter;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
