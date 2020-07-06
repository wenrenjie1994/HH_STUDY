package demo01;
/*
局部变量和成员变量
1.定义位置不一样
局部变量：方法内部
成员变量：方法外部，类里面
2.作用范围不一样
局部变量：只有方法当中才可以使用，
成员变量：整个类都可以通用
3.默认值不一样
局部变量：没有默认值
成员变量：如果没有赋值，会有默认值
4.内存位置不一样
局部变量：栈
成员变量：堆
5.生命周期不一样
局部变量：方法出栈消失
成员变量：对象消失
*/
public class Demo01PhoneParam {
    public static void main(String[] args) {
        Phone one =new Phone();
        one.brand="苹果";
        one.price=8399.0;
        one.color="土豪金";
        method(one);

    }
    public static void method(Phone param){
        System.out.println(param.color);
        System.out.println(param.price);
        System.out.println(param.brand);

    }
}
