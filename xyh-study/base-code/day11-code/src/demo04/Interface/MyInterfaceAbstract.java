package demo04.Interface;
/*
在任何版本中，接口都可以包含抽象方法
注意事项：
1.接口当中的抽象方法，修饰符必须是两个固定的关键字：public abstract
2.这两个关键字修饰符，可以选择性的省略
3.方法的三要素可以随意定义
*/
public interface MyInterfaceAbstract {

    //抽象方法
    public abstract void methodAbs1();
    //抽象方法
    void methodAbs2();
    //抽象方法
    public void methodAbs3();
    //抽象方法
    abstract void methodAbs4();

}
