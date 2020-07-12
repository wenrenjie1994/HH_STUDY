package cn.sheng.day03;

/*
 *       java内存：五个部分
 *       1.栈（Stack）                                 ：存放局部变量。方运行在栈当中
 *         局部变量                                    ： 方法参数、方法内部定义的变量
 *
 *       2.堆（Heap）                                 ：new出来的且数据都存在默认值
 *
 *       3.方法区（Method Area）                      ：存储.class相关信息，包含方法的信息。
 *
 *       4.本地方法栈（Native Method Stack）          ：与操作系统相关
 *
 *       5.寄存器（PC Register）                     ：与CPU相关
 * */


public class Demo03Mem {
    public static void main(String[] args) {
        int arrayA[] = new int[3];
        arrayA[1] = 666;

        int arrayB[] = arrayA;//两个数组地址相同
        System.out.println(arrayA[1]);//666
        System.out.println(arrayB[1]);//666

        int arrayC[] = {1, 2, 3};

//        System.out.println(arrayC[3]);//数组越界

//        int arrayD[] = null;//引用类型变量都可以赋值为null，代表空，如不初始化不能使用（空指针异常）

    }


}
