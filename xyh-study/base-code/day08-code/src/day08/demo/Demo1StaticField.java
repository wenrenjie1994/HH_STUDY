package day08.demo;
/*static用于类属性：共享*/
public class Demo1StaticField {
    public static void main(String[] args) {

        Student one=new Student("郭靖",19);
        Student two=new Student("黄蓉",16);
        //多个对象共享同一个数据
        one.room="101";
        System.out.println("姓名："+one.getName()+",年龄："+one.getAge()+",教室："+one.room+",学号："+one.getId());
        System.out.println("姓名："+two.getName()+",年龄："+two.getAge()+",教室："+two.room+",学号："+two.getId());


    }




}
