package day08.demo;

public class myclass {
    //成员变量
    String var="成员变量";
    //静态变量
    static String  varStatic="静态变量";
    //成员方法
    public void  method(){
        System.out.println("这是一个普通的成员方法，可以访问");
        //成员方法可以访问成员变量
        System.out.println(var);
        //成员方法可以访问静态变量
        System.out.println(varStatic);
    }
    //静态方法
    public static void methodStatic(){
        System.out.println("这是一个静态方法，可以访问");
        //静态方法不能访问成员变量
        //System.out.println();
        //静态方法能访问静态变量
        System.out.println(varStatic);
    }
}
