package basic.method.demo1;




public class DemoStudent {
    public static void main(String[] args) {


        Student stu = new Student();

        System.out.println(stu.name);
        System.out.println(stu.age);
        stu.name="妙龄";
        stu.age = 18;
        System.out.println(stu.name);
        stu.eat();
        stu.study("我");

    }
}

