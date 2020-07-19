package demo1;

/**
 * 类：属性和行为
 * 属性：成员变量。直接定义在类中，不放在方法中
 * 行为：成员方法。成员方法不用static关键字修饰
 *
 *
 */
public class Student {
    //成员变量
    public String name;
    public int age;
    //成员方法
    public void eat(){
        System.out.println("吃");
    }
    public void sleep(){
        System.out.println("睡");
    }
    public void study(){
        System.out.println("学习");
    }
}

