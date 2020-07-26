package demo01;
/*
* 对于成员变量，如果使用final关键字修饰，那么变量也照样是不可变
* 1.由于成员变量具有默认值，所以用了final之后必须手动赋值，不会再给默认值
* 2.对于final 的成员变量，要么直接赋值，要么使用构造方法赋值
* 3.必须保证类当中所有重载的构造方法，都最终会对final的成员变量进行赋值，而且仅有一次赋值
* */
public class Person {
    //1.直接赋值，则构造方法赋值，以及set方法进行赋值均不可用
    //private final String name="鹿晗";
    private final String name;
    public Person(){
        name="关晓彤";
    }

    public Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

  /*  public void setName(String name) {
        this.name = name;
    }*/
}
