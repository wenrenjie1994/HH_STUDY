package day03.demo;
/*
java中的内存划分
java的内存需要划分为5个部分：
1.栈（stack）：存放的都是方法中的局部变量。方法必须在栈中运行
局部变量：方法的参数、或者是方法中{}中的内部变量
作用域：一旦超出作用域，立刻从栈内存中消失
2.堆（heap）：凡是new出来的东西，都存在堆内存中
堆内存里面的东西都有一个地址值：16进制
堆内存里面的数据，都有默认值。规则：
整数：0
浮点数：0.0
字符：'\u0000'
布尔：false
引用：null
3.方法区（method area）：存放.class相关信息，包含方法信息
4.本地方法栈（native method stack）：与操作系统相关
5.寄存器（pc register）：与cpu相关
注:1.避免数组索引越界；2.空指针异常
空指针异常：例如：int[]array=null
数组必须进行new初始化，才可以使用数组中的元素，
若只赋值null，则会发生空指针异常
* */
public class Demo05 {
    public static void main(String[] args) {
        int[] array=new int[3];
        System.out.println(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println("===================");
        array[1]=10;
        array[2]=20;
        System.out.println(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println("===================");
        //两个数组产生了联系
        int[] array1=array;//两个引用指向同一个数组
        System.out.println(array1);
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println(array1[2]);
        System.out.println("===================");
        array1[1]=100;
        array1[2]=200;
        System.out.println(array1);
        System.out.println(array1[0]);
        System.out.println(array1[1]);
        System.out.println(array1[2]);
    }
}
