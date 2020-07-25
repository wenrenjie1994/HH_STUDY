package fu.day04.demo01;

/*
定义方法的完整格式：
修饰符 返回值类型 方法名称（参数类型 参数名称，。。。）{
    方法体
    return 返回值；
}
修饰符 ：现阶段的固定写法 public static
返回值类型：也就是方法最后产生的数据结果是什么类型的

定义一个两个数相加的方法，三要素
返回值类型：int
方法名称：sum
参数列表；int a,int b

f方法的三种调用格式
1.单独调用：方法名称（）；
2.打印调用：  System.out.println(方法名称（参数）)
3.赋值调用： 数据类型 变量名称=方法名称（参数）；

注意：void类型的方法，只能单独调用，不能打印和赋值调用
1.对于void方法中最后一行的return不能写后面的返回值 ，只能写return自己，可以省略
2，方法中可以有多个return，但是必须保证同时执行的只有一个，两个return不能连写
*/
public class Demo02MethodDefine {
    public static void main(String[] args) {

//        单独调用
        sum(10, 20);
        System.out.println("======");

//        打印调用
        System.out.println(sum(10, 20));
        System.out.println("========");
//           赋值调用
        int number = sum(10, 20);
        number += 100;
        System.out.println("变量的值：" + number);
    }

    //我是一个方法，我负责两个数相加
    //我有返回值Int,谁调用我我就吧计算结果告诉谁
    public static int sum(int a, int b) {
        int result = a + b;
        return result;

    }

    ///我是一个方法。我负责两个数相加。
    //我的结果不告诉任何人
    public static void sun1(int a, int b) {
        int result = a + b;
        System.out.println("结果是" + result);
    }


    //定义一个方法判断两个数值是否相同
    public static boolean isSame(int a, int b) {
        boolean same;

//        same=a==b;
//        return same;
        return a == b;
    }

    //定义一个方法，求1-100之间所有数字的和值
    //三要素：
    //返回值：有，计算结果是哟个int数字
    //方法名称：getSum
    //参数列表：数据范围已经确定，是固定的，所以不需要告诉我任何条件，不需要参数
    public static int getSum() {
        int sum1=0;
        for (int i = 0; i < 100; i++) {
            sum1 += i;
        }
        return sum1;
    }

    //定义一个方法，打印指定次数的HellWorld.
    //三要素：
    //返回值类型：没有返回值，void
    //方法名称：printH
    //参数列表：int a
    public static void printH(int a) {
        for (int i = 0; i < a; i++) {
            System.out.println("HelloWorld");
        }
    }
}
