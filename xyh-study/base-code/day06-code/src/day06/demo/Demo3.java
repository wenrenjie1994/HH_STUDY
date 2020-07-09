package day06.demo;

import java.util.ArrayList;

/*
ArrayList<e>集合类
<e>代表泛型，即集合中的所有元素全都是统一的类型
注意：
1.泛型必须是引用类型，不能是基本类型
如错误写法：ArrayList<int> list=new ArrayList<>();
若要使用ArrayList存储基本类型，必须使用对应的“包装类”（位于java.lang包下）
基本类    包装类
byte      Byte
short     Short
int       Integer   【特殊】
long      Long
float     Float
double    Double
char      Character 【特殊】
boolean   Boolean

从JDK1.5+开始，支持自动装箱、自动拆箱
自动装箱：基本类型->包装类型
自动拆箱：包装类型->基本类型
2.直接打印ArrayList，显示的不是地址而是内容，若没有内容则是[]

常用方法有：
public boolean add(E e),向集合中添加元素，参数与泛型一致
public E get(int index),从集合中获取元素，参数是索引编号，返回值就是对应位置的元素
public E remove(int index),从集合中删除元素，参数是索引编号，返回值就是被删除的元素
public int size(),获取集合的尺寸长度，返回值就是集合中的元素个数

 */
public class Demo3 {

    public static void main(String[] args) {
        //使用数组，程序运行期间长度不能发生改变
        Person[] array=new Person[3];
        Person one=new Person("张三",18);
        Person two=new Person("李四",8);
        Person three=new Person("王五",28);
        array[0]=one;
        array[1]=two;
        array[2]=three;
        System.out.println(array[1].getName());
        //如何使用ArrayList
        ArrayList<String> list=new ArrayList<>();
        //直接打印ArrayList，显示的不是地址而是内容，若没有内容则是[]
        System.out.println(list);

        //向集合中添加一些数据
        list.add("张三");
        System.out.println(list);
        //ArrayList添加元素一定可以成功，但是其他集合不一定
        boolean success=list.add("李四");
        list.add("老王");
        System.out.println(list);
        System.out.println("是否添加成功："+success);

        //从集合总获取元素，索引值从0开始
        System.out.println("=========================");
        System.out.println("第一号位置是："+list.get(0));
        //从集合中删除元素
        System.out.println("=========================");
        String whoRemoved=list.remove(0);
        System.out.println("被删除的人是："+whoRemoved);
        System.out.println(list);
        //获取集合的长度
        System.out.println("=========================");
        System.out.println("集合的长度是："+list.size());
        //遍历集合
        System.out.println("=========================");
        for (int i = 0; i < list.size(); i++) {
            String name=list.get(i);
            System.out.println(name);
        }
        //存储int基本类型
        System.out.println("=========================");
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(100);
        list1.add(200);
        System.out.println(list1);





    }

}
