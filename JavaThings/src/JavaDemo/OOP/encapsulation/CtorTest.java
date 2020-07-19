package JavaDemo.OOP.encapsulation;

public class CtorTest {
    public static void main(String[] args) {
        Student stu1 = new Student();
        Student stu2 = new Student("UeSTC");

        //①default ---> ②explicit ---> ③ctor ---> ④object.method/filed
        stu1.setName("Chen Yuqi");
        stu1.setAge(24);

        stu2.setName("Papi");
        stu2.setAge(23);

        stu1.print();
        stu2.print();
    }
}

class Student {
    String name;
    int age = 18;
    String school;

    //Constructor
    public Student() {
        this.school = "SCU";
        System.out.println("Student(*)...");
    }
    public Student(String school) {
        this();         //call constructor
        System.out.println("Student(&)...");
        this.school = school;
    }

    //setter function
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //getter function
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getSchool() {
        return school;
    }

    //print
    public void print() {
        System.out.println(name + " is " + age + " in " + school + "!!!");
    }
}
