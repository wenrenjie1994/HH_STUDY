package demo03;
/*
当方法的局部变量和类的成员变量重名时，按照就近原则，优先使用局部变量
通过谁调用的方法，谁就是this. 重名情况下区分
*/
public class Person {
    String name;
    public void sayHello(String name){
        System.out.println(name+"你好，我的名字是："+this.name);
    }
}
