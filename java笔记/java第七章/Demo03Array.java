package basic.method.demo1.day2;
//定义一个数组，用来存储三个Person对象
public class Demo03Array {
    public static void main(String[] args) {
        Person[] array = new Person[3];
        Person one = new Person("刘妙龄",18);
        Person two = new Person("梁旭猪",19);
        Person three = new Person("小猪",20);
        array[0] = one;
        array[1]= two;
        array[2] = three;

    }
}
