package demo1;

/**
 * 一般一个类无法直接使用，需要创建一个对象
 *1.导包：指出需要用的呢，在什么位置；
 * import 包名称.类名称；
 * import demo1.Student;
 * 对于和当前类属于同一包的情况下，可以省略导包语句。
 *
 * 2.创建：
 * 类名称 对象名=new 类名称（）；
 * Student stu = new Student（）；
 *
 * 3.使用：两种分类：
 * 使用成员变量：对象名.成员变量名
 * 使用成员方法：对象名.成员变量方法名（参数）；
 * 综合也就是想用谁就对象名.谁
 *
 */
public class Demo02Student {
    public static void main(String[] args) {
        Student stu=new Student();
        System.out.println(stu.name);//0
        System.out.println(stu.age);//0

        stu.name="张三";
        stu.age=18;
        System.out.println(stu.name);
        System.out.println(stu.age);

        stu.eat();
        stu.sleep();
        stu.study();
    }
}
