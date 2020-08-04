package fu.day04.demo13;
/*
接口的默认方法，可以通过接口实现类对象，直接调用
接口的默认方法，也可以被接口实现类进行覆盖重写
 */
public class DemoInterface {
    public static void main(String[] args) {
        MyInterfaceDefaultA a=new MyInterfaceDefaultA();
        a.methodAbs();//实现抽象方法，AAA

        a.methodAbaA();//这是新添加的默认方法
        System.out.println("===========");

        MyInterfaceDefaultB b=new MyInterfaceDefaultB();
        b.methodAbs();//实现抽象方法，BBB
        a.methodAbaA();//实现类B重写了默认方法
    }
}
