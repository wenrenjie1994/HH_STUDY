package day08.demo;
/*static内存中的情况*/
public class Demo3StaticStudent {
    public static void main(String[] args) {
        /*存在方法区中单独的静态区中*/
        Student.room="101教室";
        Student one=new Student("郭靖",20);
        System.out.println("one的姓名："+one.getName());
        System.out.println("one的年龄："+one.getAge());
        System.out.println("one的教师："+Student.room);
        System.out.println("=======================");
        /*根据类名称访问成员变量与对象没关系*/
        Student.room="101教室";
        Student two=new Student("黄蓉",18);
        System.out.println("two的姓名："+two.getName());
        System.out.println("two的年龄："+two.getAge());
        System.out.println("two的教师："+Student.room);
    }
}
