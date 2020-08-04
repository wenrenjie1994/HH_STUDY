package fu.day04.demo04;
/*
局部变量和成员变量
1.定义的位置不一样【重点】
局部变量：在方法的内部     成员变量：在方法的外部，直接写在类当中

2.作用范围不一样【重点】
局部变量：只有在放法中可以使用
成员变量：整个类全都可以通用。

3.默认值不一样【重点】
局部变量：没有默认值，如果要想使用，必须手动进行赋值
成员变量：如果没有赋值，会偶默认值，规则和数组一样

4.内存位置不一样
局部变量：栈
成员变量：堆

5.生命周期不一样


 */

public class VariableDifference {
    String name;//成员变量
    public void methodA(){
        int num=20;//局部变量
        System.out.println(num);//可行
        System.out.println(name);//可行
    }
    public  void methodB(int param){//方法的参数就是局部变量
        //参数在方法调用的时候，必然会被赋值
        int age;
        //System.out.println(age); 错误
        //System.out.println(num);//错误
        System.out.println(name);//可行
    }
}
