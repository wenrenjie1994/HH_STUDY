package demo03;
/*
构造方法是专门用来构造对象的方法，
用new来创建对象时，其实就是在调用构造方法
格式：
public 类名称（参数类型 参数名称）{
    方法体
}
注意事项：
1.构造方法的名称必须和所在类的名称完全一样
2.构造方法不要写返回值，连void也不写
3.构造方法不能return具体返回值
4.如果没有构造方法，编译器将默认赠送一个构造方法
5.一旦编写了至少一个构造方法，编译器将不再赠送
6.构造方法也是可以重载的
*/
public class Student {
    private String name;
    private int age;
    public Student(){
        System.out.println("无参数方法体执行了");
    }
    public Student(String name,int age){
        System.out.println("全参数方法体执行了");
        this.name =name;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
}
