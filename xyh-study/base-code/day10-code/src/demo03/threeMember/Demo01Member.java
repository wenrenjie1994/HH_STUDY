package demo03.threeMember;
/*
三种变量重名：
解决方案：
1.局部变量，直接使用
2.子类本身的变量，this.变量名
3.父类的变量，super.变量名
*/
public class Demo01Member {
    public static void main(String[] args) {
        Son son=new Son();
        son.method();
    }
}
