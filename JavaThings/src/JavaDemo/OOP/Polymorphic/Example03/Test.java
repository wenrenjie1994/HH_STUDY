package JavaDemo.OOP.Polymorphic.Example03;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.eat();

        System.out.println("--------------");
        Student s1 = new Student();
        s1.age = 18;
        s1.eat();
        s1.isCollege = true;
        s1.study();

        System.out.println("--------------");
        /*
        polymorphic
        父类的引用指向子类的对象，执行被子类重写的父类方法(compile父类的方法)
         */
        Person p2 = new Student();
        Person p3 = new Teacher();

        p2.eat();
        p2.traffic();
        System.out.println(p2.name);
        System.out.println(p2.idCard);
        /*
        p2.study();                 //error
         */

        //downcast  force!!!
        /*
        Student s2 = (Student)p2;
        s2.study();
        ((Student) p2).study();
        */

        //to avoid exception when downcast, use instanceof to judge
        if (p2 instanceof Student) {
            Student s2 = (Student)p2;
            s2.study();
            System.out.println("------- Student -------");
        }

        Student s2 = new Student(true, 201615);
        s2.name = "Tom";
        Student s3 = new Student(true, 201615);
        s3.name = "Mark";
        System.out.println(s2.equals(s3));

        System.out.println(s2);
        System.out.println(s2.toString());
    }
}
