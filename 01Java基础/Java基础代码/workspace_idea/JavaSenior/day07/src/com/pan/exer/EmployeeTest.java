package com.pan.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中
 * （下一章： TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
 * @author zhaopan@163.com
 * @creat 2020-04-21 13:56
 */
public class EmployeeTest {

    //使用自然排序
    //1). 使 Employee 实现 Comparable 接口，并按 name 排序
    @Test
    public void test1(){

        TreeSet set = new TreeSet();
        Employee e1 = new Employee("liu",55,new MyDate(1963,8,12));
        Employee e2 = new Employee("zhang",45,new MyDate(1953,7,15));
        Employee e3 = new Employee("guo",34,new MyDate(1947,23,12));
        Employee e4 = new Employee("li",55,new MyDate(1989,8,19));
        Employee e5 = new Employee("liang",55,new MyDate(1946,7,11));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }


    //使用定制排序
//    2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序。
    @Test
    public void test2(){


        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    //  比较年
                    int minusYear = b1.getYear() - b2.getYear();
                    if(minusYear !=0){
                        return minusYear;
                    }
                    //  比较月
                    int minusMonth = b1.getMonth()-b2.getMonth();
                    if(minusMonth!=0){
                        return minusMonth;
                    }
                    //  比较日
                    return b1.getDay()-b2.getDay();
                }else{
                    throw new RuntimeException("输入数据类型不一致！");
                }
            }
        });

        Employee e1 = new Employee("liu",55,new MyDate(1963,8,12));
        Employee e2 = new Employee("zhang",45,new MyDate(1953,7,15));
        Employee e3 = new Employee("guo",34,new MyDate(1947,23,12));
        Employee e4 = new Employee("li",55,new MyDate(1989,8,19));
        Employee e5 = new Employee("liang",55,new MyDate(1946,7,11));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }










}
