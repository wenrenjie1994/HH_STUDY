package demo01;
/*
类不能直接使用，需要先创建对象
1.导包
import demo01.Students;
2.创建对象
Students stu =new Students();
3.使用
使用成员变量：对象名.成员变量名
使用成员方法：对象名.成员方法名
*/
public class Demo01Students {
    public static void main(String[] args) {
        Students stu = new Students();
        System.out.println(stu.name);
        System.out.println(stu.age);

        stu.name="赵丽颖";
        stu.age=18;
        System.out.println(stu.name);
        System.out.println(stu.age);

        stu.eat();
        stu.sleep();
        stu.study();
    }
}
