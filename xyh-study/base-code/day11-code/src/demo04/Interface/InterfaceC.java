package demo04.Interface;
/*
接口之间的多继承
该接口共有4个接口方法
*/
public interface InterfaceC extends InterfaceA,InterfaceB {
    public abstract  void methodC();

/*    @Override
    void methodA();

    @Override
    void common();*/
    //多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写
   // 【而且必须带有defalut关键字】
    @Override
    default void method() {
        System.out.println("多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写");
    }

/*    @Override
    void methodB();*/
}
