package Array;

/*
直接打印数组名称，得到的是数组对应的：内存地址哈希值

访问数组元素的格式：数组名称[索引值]
索引值：就是一个int数组，代表数组当中元素的编号

使用动态初始化数组的时候，其中的元素将会自动拥有一个默认值，规则如下：
如果是整数类型，那么默认为0；
如果是浮点类型，那么默认为0.0
如果是字符类型，那么默认为‘\u0000’
如果是布尔类型，那么默认为false
如果是引用类型，那么默认为null

注意事项：
静态初始化其实也有默认值的过程，只不过系统自动马上将默认值替换成为了大括号当中的具体数值

【注意】索引值从0开始，一直到“驻足长度-1”为止
如果访问数组元素的时候，索引编号并不存在，那么将会发生数组索引越界异常
ArrayIndexOutOfBoundsException

原因：索引编号写错了
解决：修改成为存在的正确索引编号

所有的引用类型变量：都可以赋值为null值，但是代表其中什么都没有

数组必须进行new初始化才能使用其中的元素。
如果只是赋值了一个null，没有进行new创建，那么将会发生：
空指针异常 NullPointerException

原因：忘了new
解决：补上new

Java在调用方法，传递参数的时候，采用的是pass-by-copy的方法，传递一份内容的拷贝，即传值。
基本数据类型的变量是存储在栈内存中，而引用类型变量存储在栈内存中，保存的是实际对象在堆内存中的地址，实际对象其实是在堆上的。
Java是传值(pass-by-value)的，传过去的也是一个值的copy，但是引用型(Reference Type)变量
里面存放的值是对象的地址，那么传递过去的就是原对象的地址。也就是说，在方法中的数组指向的地址和原数组指向的地址是一样的，而
我们对数组操作时是操作数组指向的地址段中的内容，方法内和方法外操作的是同一段内存，那么自然改变也是同步的。

 */

public class DemoArrayUse {
    public static void main(String[] args) {
        //静态初始化的省略格式
        int[] array = {10, 20, 30};

        System.out.println(array);//[I@1b6d3586

        System.out.println(array[0]);//10
        System.out.println(array[1]);//20
        System.out.println(array[2]);//30

        /*
        如何获取数组的长度，格式：
        数组名称.Length
         */
        int[] arrayLenth = new int[3];

        int[] arrayLenthB = {10, 20, 30, 40, 1, 4, 6};
        int len = arrayLenthB.length;
        System.out.println(len);

        //遍历数组
        for(int i=0;i<arrayLenthB.length;i++){
            System.out.println(arrayLenthB[i]);
        }

        //求数组中的最小值
        int[] arrayMin = {5, 15, 30, 20, 1000, -20, 35};

        int min = array[0];
        for (int i = 1; i < arrayMin.length; i++) {
            if (arrayMin[i] < min) {
                min = arrayMin[i];
            }
        }
        System.out.println("最小值" + min);

        //数组元素反转：不使用新的数组
        for(int minn = 0, max = arrayLenthB.length-1;minn<max;minn++,max--){
            int temp = arrayLenthB[minn];
            arrayLenthB[minn] = arrayLenthB[max];
            arrayLenthB[max] = temp;
        }
        for(int i=0;i<arrayLenthB.length;i++){
            System.out.println(arrayLenthB[i]);
        }

    }
}
