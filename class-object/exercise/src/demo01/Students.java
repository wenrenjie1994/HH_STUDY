package demo01;
//定义学生类
//属性：姓名、年龄
//行为：吃饭睡觉学习
//对应：
//成员变量：String name ;int age;
//成员方法:
/*
 public void eat(){}
 public void sleep(){}
 public void study(){}
*/
//成员方法不要写static关键字
public class Students {
    String name;
    int age;
    //成员方法
    public void eat(){
        System.out.println("吃饭");
    }
    public void sleep(){
        System.out.println("睡觉");
    }
    public void study(){
        System.out.println("学习");
    }
}
