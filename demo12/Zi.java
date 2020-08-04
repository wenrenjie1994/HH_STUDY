package fu.day04.demo12;
/*
super 关键字的用法有三种
1.在子类的成员方法中，访问父类的成员变量
2.在子类的成员方法中，访问父类的成员方法
3.在子类的构造方法中，访问父类的构造方法

this d的三种方法
1.在本类的成员方法中，访问本类的成员变量
2.在本类的成员方法中，访问本类的另一个成员方法
2.在本类的构造方法中，访问本类的另一个构造方法
注意：A.this(...)调用也必须是构造方法的第一个语句，唯一一个
    B。super和this两种构造调用，不能同时调用
 */
public class Zi extends Fu{
    int num=20;

    public Zi() {
        //super();//这一行不再赠送
        this(127);//本类的无参构造调用本类的有参构造
    }

    public Zi(int num) {
        this.num = num;
    }

    @Override
    public void method() {
       System.out.println("子类");
       super.method();//访问父类的method
    }

    public void methodZi(){
        System.out.println(super.num);//父类中的num
    }

    public void methodA(){
        System.out.println("AAA");//父类中的num
    }

    public void methodB(){
        this.methodA();//掉用本类中的其他方法
        super.methodFu();//调用父类中的方法
        System.out.println("BBB");//父类中的num
    }
}
