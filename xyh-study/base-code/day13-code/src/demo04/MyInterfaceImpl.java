package demo04;

public class MyInterfaceImpl implements MyInterface {
    @Override
    public  void  method(){
        System.out.println("实现类覆盖重写了方法");
    }
    public  void  method2(){
        System.out.println("实现类覆盖重写了方法2");
    }
}
