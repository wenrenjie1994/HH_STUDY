package demo02;
/*
* 多态的前提：extends继承与implements实现
* 代码中体现多态性：父类引用指向子类对象即右侧对象被当成左侧引用类来使用
* 格式：
* 父类名称  对象名 =new 子类名称();
* 或者
* 接口名称 对象名=new 实现类名称();
* */
public class DemoMulti {
    public static void main(String[] args) {
        Fu obj =new Zi();
        obj.method();
        obj.methodFu();
        //子类特有方法无法使用
        //obj.methodZi();
    }
}
