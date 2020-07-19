package demo2;

/**
 * 构造方法是专门用来创建对象的方法，当我们通过关键字new来创建对象时，其实就是调用构造方法。
 * 格式：
 * public 类名称（参数类型 参数名称）{
 *     方法体
 * }
 *
 * 【注意】
 * 1.构造方法的名称必须和所有的类名称完全一样
 * 2，构造方法不要写返回值类型，连void都不要写
 * 3.构造方法中不能return一个具体的返回值
 * 4.如果没有编写任何构造方法，那么编译器将会默认赠送一个构造方法，没有参数，
 * 什么都不做。
 * 5.一旦编写了至少一个构造方法，那么编译器将不再赠送。
 */
public class Student {
    //1.成员变量
    private String name;
    private int age;
    //2.无参构造方法
    public Student(){
        System.out.println("无参构造方法成功执行了");
    }
    //3.全参数构造方法
    public Student(String name,int age){
        System.out.println("有参构造方法成功执行了");
        this.name=name;
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    //4.getter与setter
    public void setAge(int age){
        this.age=age;
    }
    public int getAge(){
        return age;
    }
}
