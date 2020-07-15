package demo07.Super;
/*
super关键字的用法有三种
1.在子类成员方法中，访问父类的成员变量
2.在子类成员方法中，访问父类的成员方法
3.在子类的构造方法中，访问父类的构造方法
*/
public class Son extends Father{
    int num=20;

    public Son(){
        super();
    }
    public void methodSon(){
        System.out.println(num);
        //1.在子类成员方法中，访问父类的成员变量
        System.out.println(super.num);
    }
    public void method(){
        //2.在子类成员方法中，访问父类的成员方法
        super.method();
        System.out.println("子类的成员方法");
    }
}
