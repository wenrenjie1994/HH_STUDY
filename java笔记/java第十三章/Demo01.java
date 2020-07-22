package basic.method.demo1.day11;

import java.util.LinkedHashSet;

public class Demo01 {
    public static void main(String[] args) {
        LinkedHashSet<Person> set = new LinkedHashSet<>();
        Person p1= new Person("刘",18);
        Person p2 = new Person("刘",18);//重写了Hashcode方法和equals方法，不能存储相同的对象
        Person p3 = new Person("刘", 20);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);

    }
}
