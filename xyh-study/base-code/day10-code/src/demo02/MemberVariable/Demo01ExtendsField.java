package demo02.MemberVariable;
/*
在子类的继承关系当中，如果成员变量与父类的成员变量重名，则创建子类对象时，有两种访问方式
1.直接通过子类对象访问成员变量：
等号左边是谁，就优先用谁，没有则向上找
2.间接通过成员方法访问成员变量
该方法属于（在哪里定义）谁就优先用谁，没有则向上找


* */
public class Demo01ExtendsField {
    public static void main(String[] args) {
        //创建父类的对象
        Father f=new Father();//10
        //父类只能使用自身的成员变量
        System.out.println(f.numFather);
        System.out.println("===========================");
        //创建子类对象
        Son s=new Son();
        //子类可以访问父类的成员变量
        System.out.println(s.numFather);//10
        System.out.println(s.numSon);//20
        System.out.println("===========================");

        //重名情况1：等号左边是谁，就优先用谁，没有则向上找
        //子类的num值
        System.out.println(s.num);//40
        System.out.println("===========================");

        //重名情况2：该方法属于（在哪里定义）谁就优先用谁，没有则向上找
        //这个方法是在子类中定义的，优先使用子类，没有再向上找
        s.methodSon();//40
        //这个方法是父类中定义的
        s.methodFather();//30



    }
}
