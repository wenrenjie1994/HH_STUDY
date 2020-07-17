package demo04.Interface;
/*
* 注意：不能通过接口实现类的对象来调用接口当中的静态方法
* 正确用法：通过接口名称直接调用其中的静态方法
* */
public class Demo03MyInterfaceStatic {
    public static void main(String[] args) {
        //通过接口名称直接调用其中的静态方法
        MyInterfaceStatic.methodStatic();
    }
}
