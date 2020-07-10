package com.pan.exer;

/** 定义一个 Employee 类。
 * 该类包含：private 成员变量 name,age,birthday，
 * 其中 birthday 为 MyDate 类的对象；
 * 并为每一个属性定义 getter, setter 方法；
 * 并重写 toString 方法输出 name, age, birthday
 * @author zhaopan@163.com
 * @creat 2020-04-21 13:53
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //按照name排序
    @Override
    public int compareTo(Object o) {
       if(o instanceof Employee){
           Employee e = (Employee) o;
           return this.name.compareTo(e.name);//从小到大
       }else{
//           return 0;
           throw new RuntimeException("传入的数据类型不匹配");

       }
    }
}
