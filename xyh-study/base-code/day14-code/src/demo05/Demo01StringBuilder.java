package demo05;
/*jva.lang.StringBuilder类
* 字符串是常量，它们的值在创建之后不能更改
* 底层是一个数组，被final修饰
* private final byte[] value;
* 进行字符串的相加，内存中就会有多个字符串，效率低下
* String s= "a"+"b"+"c"="abc"
* "a" "b" "c"分别占用三个字符串
* "a"+"b"="ab"占用一个字符串
* "ab"+"c"="abc"占用一个字符串
* 共占用5个字符串
* StringBuilder类：
* 字符串缓冲区：可以提高字符串的操作效率（看成一个长度可变的字符串）
* 底层也是一个数组，但没有被final修饰，可改变长度
* byte [] value=new byte[16];
* 在内存中始终是一个数组，占用的空间少，效率高
* 如果超出初始容量16，会自动扩容
*
* 一、构造方法
* StringBuilder():构造一个不带任何字符串生成器，起初始容量为16个字符
* StringBuilder(String str):构造一个字符串生成器，并初始化指定的字符串内容
*
* 二、成员方法
* public StringBuilder append(.....):添加任意类型数据的字符串形式，并返回当前对象自身
* public String toString()：将当前StringBuilder对象转化为String对象
* 注：该方法返回的是this
* StringBuilder和String可以相互转换
* String->StringBuilder:使用构造方法StringBuilder(String str)
* StringBuilder->String：可以使用StringBulder中的toString方法public String toString()
*
* */
public class Demo01StringBuilder {
    public static void main(String[] args) {
        //空参数构造方法
        StringBuilder bu1=new StringBuilder();
        //带字符串的构造方法
        StringBuilder bu2=new StringBuilder("abc");
        System.out.println("bu1:"+bu1);
        System.out.println("bu2:"+bu2);
        System.out.println("========================");

        StringBuilder bu3=new StringBuilder();
        StringBuilder bu4= bu3.append("abc");//把bu3的地址复制给bu4
        System.out.println(bu3);
        System.out.println(bu4);
        System.out.println(bu4==bu3);//引用类型比较地址，true，所以不用接受返回值
        System.out.println("========================");
        /*链式编程：方法返回值是一个对象，可以继续调用*/
        bu3.append("abccc").append(true).append(8.8).append('中');
        System.out.println(bu3);
        System.out.println("========================");

        String str="hello";
        System.out.println("str:"+str);
        StringBuilder bu=new StringBuilder(str);
        bu.append("world");

        String s=bu.toString();
        System.out.println("s:"+s);





    }
}
