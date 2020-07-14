package demo04.method;
/*
父类与子类方法重名
创建的对象是谁就优先用谁，没有再网上找
注：
无论是成员方法还是成员变量，如果没有都是网上找父类，绝对不会往下找子类
* */
public class Demo01Method {
    public static void main(String[] args) {
        Son son=new Son();
        son.methodS();
        son.methodF();
        System.out.println("======================");
        //创建的是子类对象，优先使用子类方法
        son.method();


    }
}
