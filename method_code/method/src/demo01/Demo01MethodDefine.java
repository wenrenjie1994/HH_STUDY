package demo01;
/*
参数
返回值
方法完整格式、
修饰符 返回值类型 方法名称(参数类型 参数名称, ...){
    方法体
    return 返回值；
}
修饰符 public static
return 后面的返回值必须和方法名称前的返回值类型一样
定义两个int数字相加的方法

方法的三种调用格式
1.单独调用：方法名称（参数）；
2.打印调用：Syetem.out.println(方法名称（参数）)；
3.赋值调用:数据类型 变量名称 = 方法名称（参数）;
*/
public class Demo01MethodDefine {
    public static void main(String[] args) {
//         单独调用
        sum(10,20);
        System.out.println("========");
//        打印调用
        System.out.println(sum(10,20));
        System.out.println("========");
//        赋值调用
        int number =sum(1,5);
        System.out.println(number);
    }
    public static int sum(int a,int b){
        int result = a+b;
        return result;
    }
}
