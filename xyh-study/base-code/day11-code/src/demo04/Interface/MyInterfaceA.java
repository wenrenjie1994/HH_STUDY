package demo04.Interface;

public interface MyInterfaceA {
    public abstract  void A();
    public abstract  void C();
    public default  void D(){
        System.out.println("抽象A类的默认方法");
    }
}
