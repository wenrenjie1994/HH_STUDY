package demo04.Interface;

public class MyInterfaceDefaultB implements MyInterfaceDefault{
    @Override
    public void methodAbs() {
        System.out.println("抽象方法的实现 BBBB");
    }
    @Override
    public void  methodDefault(){
        System.out.println("覆盖重写接口中的默认方法");
    }
}
