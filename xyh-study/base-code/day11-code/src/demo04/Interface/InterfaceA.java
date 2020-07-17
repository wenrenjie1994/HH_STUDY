package demo04.Interface;

public interface InterfaceA {
    public abstract  void methodA();
    public abstract void common();
    public default  void  method() {
        System.out.println("接口A的默认方法");
    }
}
