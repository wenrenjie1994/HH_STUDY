package demo03.threeMember;

public class Son  extends Father{
    int num=20;
    public void method(){
        int num=30;
        //局部变量
        System.out.println(num);
        //自身的变量
        System.out.println(this.num);
        //父类的变量
        System.out.println(super.num);
    }

}
