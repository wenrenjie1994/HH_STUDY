package demo01;
/*
* final 关键字代表最终，不可改变的
* 常见四种用法：
* 1.修饰一个类
* 2.修饰一个方法
* 3.修饰一个局部变量
* 注：对于基本变量来说，不可变说的是变量当中的【数据】不可改变；
*     对于引用类型来说，不可变说的是变量当中的【地址】不可改变；
* 4.修饰一个成员变量
* */
public class Demo01Final {
    public static void main(String[] args) {
        int num=10;
        System.out.println(num);
        num=20;
        System.out.println(num);

        System.out.println("================");
        //一旦使用final用来修饰局部变量，那么这个变量就不能进行更改
        final int num1=200;
        System.out.println(num1);
        /*num1=20;//错误写法*/

        //只要保证有唯一赋值即可
        final int num2;
        num2=30;

        Student stu=new Student("linda");
        System.out.println(stu);//@723279cf
        System.out.println(stu.getName());
        stu=new Student("dora");
        System.out.println(stu);//@10f87f48,地址值发生了改变
        System.out.println(stu.getName());

        final Student stu1=new Student("高圆圆");
        System.out.println(stu1.getName());
        //尝试重新new一个对象进行赋值，失败。
        //stu1=new Student("赵又廷");

        //但是其中的内容可以改变
        stu1.setName("赵又廷");
        System.out.println(stu1.getName());

    }
}
