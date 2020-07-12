package day08.demo;
/*静态代码块
* 静态内容总是优先于非静态，
* 所以静态代码块比构造方法先执行
注：静态代码块的典型用途是用来一次性对静态成员变量进行赋值
* */
public class Demo4StaticBlock {
    public static void main(String[] args) {
        Person one=new Person();
        System.out.println("==============");
        Person two=new Person();
    }
}
