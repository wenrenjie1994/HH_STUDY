package demo04.Interface;


import jdk.swing.interop.SwingInterOpUtils;

public class MyInterfaceimpl  implements MyInterfaceA,MyInterfaceB{
    @Override
    public void A() {
        System.out.println("覆盖重写了A方法");
    }

    @Override
    public void B() {
        System.out.println("覆盖重写了B方法");
    }

    @Override
    public void C() {
        System.out.println("覆盖重写了A、B接口都有的抽象方法");
    }

    @Override
    public void D() {
        System.out.println("对多个接口当中冲突的默认方法进行了覆盖重写");
    }
}
