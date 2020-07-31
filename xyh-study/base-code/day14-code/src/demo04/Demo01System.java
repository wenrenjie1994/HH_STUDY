package demo04;

import java.util.Arrays;

/*
java.lang.System类中提供了大量的静态方法，可以获取系统相关的信息或操作系统级操作，
public static long currentTimeMillis()：返回以毫秒为单位的当前时间。
public static void arraycopy(Object src,
                             int srcPos,
                             Object dest,
                             int destPos,
                             int length)：将数组中指定的数据拷贝到另一个数组中
src：源数组
srcPOS：源数组中的起始位置（索引）
dest：目标数组
destPos：目标数据中的起始位置
length：要赋值的数组元素长度
*/
public class Demo01System {
    public static void main(String[] args) {
        demo01();
        demo02();
    }

    private static void demo02() {
        /*
        *练习：
        * 将src数组中前个元素，复制到dest数据的前3个位置上
        * 复制元素前：
        * src=[1,2,3,4,5]; dest=[6,7,8,9,10]
        * 复制元素后
        * dest=[1,2,3,9,10];
        * */
        int [] src={1,2,3,4,5};
        int [] dest={6,7,8,9,10};
        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(dest));
    }

    private static void demo01() {
        /*用来测试程序的效率，验证for循环打印1-999所需要使用的时间（毫秒）*/
        long start = System.currentTimeMillis();
        for(int i=1;i<=999;i++){
            System.out.println(i);
        }
        long end=System.currentTimeMillis();
        System.out.println("程序共耗时："+(end-start)+"ms" );
    }
}
