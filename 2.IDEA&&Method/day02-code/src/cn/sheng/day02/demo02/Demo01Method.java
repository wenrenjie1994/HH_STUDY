package cn.sheng.day02.demo02;

/*
方法类比c里面的函数
若干语句的功能集合

格式：
        修饰符  返回值  方法名称 （参数类型　 参数名称）{
            方法体
            return 返回值；
        }

方法应该定义在类中

ps: 快速写for循环：

            100.fori     循环100次
            for（int i = 0；i < 100; i++） {

            }

*/

public class Demo01Method {

    public static void main(String[] args) {
        System.out.println(sum(10, 20));

    }

    public static int sum(int a, int b) {
        int result = a + b;
        return result;
    }


}
