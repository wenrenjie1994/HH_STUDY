package demo04.Interface;
/*
接口的默认方法可以通过该接口的实现类对象直接调用
接口的默认方法可以通过该接口的实现类对象覆盖重写
*/
public class Demo02Default {
    public static void main(String[] args) {
        //创建实现类对象
        MyInterfaceDefaultA a=new MyInterfaceDefaultA();
        a.methodAbs();
        //调用默认方法，如果实现类没有，会向上找接口
        a.methodDefault();
        System.out.println("===============");
        MyInterfaceDefaultB b=new MyInterfaceDefaultB();
        b.methodAbs();
        b.methodDefault();
    }
}
