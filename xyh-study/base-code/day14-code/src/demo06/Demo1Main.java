package demo06;
/*
一、包装类：
基本数据类型，使用起来非常方便，但没有对应的方法来操作这些基本类型的数据，
可以使用一个类，把基本类型的数据装起来，在类定义中一些方法，这个类叫做包装类，
可以使用类中的方法来操作这些基本类型的数据。
基本类型    对应的包装类
byte       Byte
short      Short
int        Integer
long       Long
float      Float
double     Double
char       Character
boolean    Boolean

二、装箱：把基本类型的数据，包装到包装类中（基本类型的数据->包装类）
构造方法：
Integer(int value)构造一个新分配的Integer对象，它表示指定的int值
Integer(String s)构造一个新分配的Integer对象，它表示String 参数所指示的int值
传递的字符串，必须是基本类型的字符串，否则会抛出异常.如："100"正确，"A"抛出异常
静态方法：
static Integer valueOf(int i):返回一个表示指定的int值的Integer实例
static Integer valueOf(String s):返回保存指定的String的值的Integer

三、拆箱：在包装类中取出基本类型的数据（包装类-> 基本类型的数据）
成员方法：
int intValue() 以int类型返回该Integer的值
*/
public class Demo1Main {
    public static void main(String[] args) {
        //装箱
        //构造方法
        Integer in1=new Integer(1);//方法上有横线，证明方法已过时
        System.out.println(in1);
        Integer in2=new Integer("1");//方法上有横线，证明方法已过时
        System.out.println(in2);
        //静态方法
        Integer in3=Integer.valueOf(1);
        System.out.println(in3);
        Integer in4=Integer.valueOf("1");
        System.out.println(in4);
        //Integer in5=Integer.valueOf("A");//NumberFormatException异常

        //拆箱
        int i=in1.intValue();
        System.out.println(i);

    }
}
