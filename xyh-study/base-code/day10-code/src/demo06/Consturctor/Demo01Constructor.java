package demo06.Consturctor;
/*
继承关系中，父子类构造方法的访问特点
1.子类构造方法中有一个默认隐含的“super()”调用。前提：父类是无参数的构造函数
因此在创建子类对象时，先调用父类构造方法，再调用子类构造方法。
2.可以通过super关键字来调用父类重载构造
3.super父类构造调用，必须是子类构造方法的第一个语句。不能一个子类构造调用多次super
总结：
子类必须调用父类构造方法，不写则默认为super()。写了则用指定的super调用，
而且必须是构造函数中的第一个语句
*/
public class Demo01Constructor {

    public static void main(String[] args) {
        Son son=new Son();//父类构造方法 子类构造方法

    }

}
