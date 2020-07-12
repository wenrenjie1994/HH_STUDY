package day08.demo;
/*
static修饰成员方法（静态方法）：不属于对象，属于类
注：
1.如果没有static关键字，那么必须首先创建对象，然后通过对象才能使用他
2.无论是成员变量还是成员方法，如果有static修饰，推荐使用类名进行调用
静态变量：类名.静态变量
静态方法：类名.静态方法()
注意事项：
1.静态不能直接访问非静态
因为在内存中先有静态后有非静态“后人知道先人，先人不知道后人”
2.静态方法中不能用this关键字
因为this代表当前对象。但是静态方法与对象无关
*/
public class Demo2StaticMethod {
    public static void main(String[] args) {
        //成员方法
        myclass obj=new myclass();
        obj.method();
        //静态方法的调用（推荐）
        myclass.methodStatic();
        //静态方法的调用（不推荐）
        obj.methodStatic();
        //调用自己的静态方法可省略类名称
        myMethod();
    }

    public static void myMethod(){
        System.out.println("这是一个自己的方法");
    }
}
