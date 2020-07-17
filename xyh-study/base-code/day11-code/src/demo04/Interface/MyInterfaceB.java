package demo04.Interface;

public interface MyInterfaceB {
    public abstract  void B();
    public abstract  void C();
    public default  void D(){
        System.out.println("抽象B类的默认方法");
    }
}
