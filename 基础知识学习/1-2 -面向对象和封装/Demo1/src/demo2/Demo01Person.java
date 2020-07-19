package demo2;
/**
 *当方法的局部变量和类的成员变量重名的时候，根据“就近原则”,优先使用局部变量
 * 如果访问本类当中的成员变量，需要使用格式：
 * this.成员变量名
 *
 * 通过水调用的方法，谁就是this
 *
 */

public class Demo01Person {
    public static void main(String[] args) {
        Person person=new Person();
        person.name="王健林";
        person.sayHello("王思聪");
    }
}
