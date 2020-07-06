package demo02;
//一旦使用了private进行修饰，本类中依然可以使用，
/*
但是超出了本类范围之外就不能直接访问了；
间接访问成员变量：必须用set get方法、
get方法必须要有返回值
set不能有返回值
*/
public class Person {
    String name;
    private int age;
    public void show(){
        System.out.println("我叫"+name+",年龄是"+age);
    }
    //专门设置成员变量age的值
    public void setAge(int num){
        if(num<100&&num>=0){
            age=num;
        }else{
            System.out.println("数据不合理");
        }
    }
    //专门获取age
    public int getAge(){
        return age;
    }
}
