package fu.day04.demo01;

/*
动态初始化（指定长度）：在创建数组的时候，直接指定数组当中数据元素的个数
静态初始化（指定内容）：在创建数组的时候，不直接指定数据个数多少，而是直接将具体的
                    数据内容指定

使用动态初始化数组的时候，其中的元素将会自动拥有一个默认值，规则如下：
int 型，默认为0
float型，默认为0.0
char型，默认为‘\u0000’
boobeal型，默认为false
引用类型，默认为null

所有的引用类型变量，都可赋值为一个null值，但是代表其中什么也没有

静态初始化基本格式：
数据类型【】 数组名称=new 数据类型【】{元素1，元素2，。。。。}
省略格式：
数据类型【】 数组名称= {元素1，元素2，。。。。}

注意事项：
虽然静态初始化没有直接告诉长度，但可以根据内容推断出长度
 */
public class Demo03Array {
    public static void main(String[] args) {

        //动态初始化基本格式
        int[] arrayA = new int[300];
        double[] arrayB = new double[10];

        //静态初始化
        int[] arrayC = new int[]{5, 15, 30};
        String[] arrayD = new String[]{"hello", "world"};

        //省略格式
        int[] arrayE = {10, 23};

        //初始化过程可以拆分为两步
        int[] arrayF;
        arrayF = new int[3];

        int[] arrayG;
        arrayG = new int[]{1, 2, 3};

        //静态初始化的省略格式不可以拆分
        //int[] arrayH;
        //arrayH={1,2,3}   错误的

        //数组的使用：
        int[] array = {10, 20, 30};
        //直接打印数组名称，得到的是数组对应的内存地址哈希值
        System.out.println(array);//[I@16d35

        //访问数组元素的格式： 数组名称[索引值]
        //索引值，就是值从0开始，一直到“数组的长度-1”为止
        //若果访问数组元素的时候，索引号不存在，发生数组索引越界现象
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        //空数组
        /*数组必须进行new初始化才能使用其中的元素，
        如果只是赋值了一个null，没有进行new创建
        那么将会发生，空指针异常  nullpointerexcepton
        */
        int[] arrayJ=null;
        arrayJ=new int[3];//缺少这一行将出错
        System.out.println(arrayJ[0]);

        int len=array.length;//获取数组的长度


    }
}
