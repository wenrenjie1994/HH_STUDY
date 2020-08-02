package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo03AgeSort {
    public static void main(String[] args) {
        Person[] array = {
                new Person("张三",20),
                new Person("李四",16),
                new Person("王五",18)
        };
        //对数组中的Person对象使用Arrays的sort方法通过年龄进行升序（前边-后边）排序
        //使用匿名内部类
        /*Arrays.sort(array, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        //使用Lambda表达式
        Arrays.sort(array, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();
        });

        //Lambda表达式省略优化
        Arrays.sort(array, (o1, o2) -> o1.getAge() - o2.getAge());

        //遍历数组
        for (Person person : array) {
            System.out.println(person.toString());
        }

    }
}
