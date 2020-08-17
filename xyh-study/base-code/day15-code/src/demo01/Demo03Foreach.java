package demo01;

import java.util.ArrayList;

/*
* 增强for循环——迭代器
 * 底层使用的也是迭代器，使用for循环的格式，简化了迭代器的书写
 * Collection<E>extends Iterable<E>:所有的单列集合都可以使用增强for循环
 * public interface Iterable<T>实现接口允许对象成为“foreach”语句目标
 *
 * 增强for循环：用来遍历集合和数组
 * 格式：
 * for(集合/数组的数据类型 变量名:集合名称/数组名称){
 *          sout(i);
 * }
 * 注：目标只能是Collection或者数组。
* */
public class Demo03Foreach {
    public static void main(String[] args) {
        demo01();
        demo02();

    }

    private static void demo02() {
        ArrayList<String> list=new ArrayList<>();
        list.add("Dora");
        list.add("Tom");
        list.add("Timmy");
        for(String s:list){
            System.out.println(s);
        }
    }

    private static void demo01() {
        int [] arr={1,2,3,6,9};
        for(int i:arr){
            System.out.println(i);
        }
    }
}
