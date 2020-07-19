package demo2;

public class Person {
    String name;

    //参数who，对方的名字
    //成员变量name，我自己的名字
    public void sayHello(String name){
        System.out.println(name+",你好。我是"+this.name);
    }
}
