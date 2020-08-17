package demo02;

import java.util.ArrayList;
import java.util.Iterator;

/*泛型的通配符
* 当不知道使用什么类型来接收的时候，此时可以使用?,?表示未知通配符
* 此时只能接收数据，不能往集合中存储数据
* 使用方法：
* 1.不能创建对象时使用
* 2.只能作为方法的参数使用
*
* */
public class Demo05Generic {
    public static void main(String[] args) {
        ArrayList<Integer> list01=new ArrayList<>();
        list01.add(1);
        list01.add(2);

        ArrayList<String> list02=new ArrayList<>();
        list02.add("a");
        list02.add("b");

        /*定义一个方法，能遍历所有类型的ArrayList集合，
        * 这时候我们不知道ArrayList集合使用什么类型，可以用泛型通配符？来接收数据类型
        * 注意：泛型没有继承的概念
        *
        * */

    }
    public static void printArray(ArrayList<?> list){
        Iterator<?> it=list.iterator();
        //it.next()方法取出的元素是Object,可以接收任意的数据类型
        while(it.hasNext()){
            Object o=it.next();
            System.out.println(o);
        }

    }
}
