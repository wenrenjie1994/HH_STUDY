package fu.day04.demo11;
/*
局部变量：        直接写成员变量
本类的成员变量：    this.成员变量名
父类的成员变量：    super。成员变量名

 */
public class Teacher extends Emploree{
    int num=20;
    public void methodzi(){
        System.out.println(num);//本类中的num
    }
    public void method1(){
        int num=30;
        System.out.println(num);//30
        System.out.println(this.num);//20
        System.out.println(super.num);//10

    }
}
