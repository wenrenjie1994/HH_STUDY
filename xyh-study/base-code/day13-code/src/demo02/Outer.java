package demo02;
/*
内部类与外部内的重名问题
*/
public class Outer {
    int num=10;
    public class  Inner{
        int num=20;

        public void methodInner(){
            int num=30;
            System.out.println("内部内成员变量"+this.num);//内部内成员变量,20
            System.out.println("局部变量"+num);//局部变量就近原则，30
            System.out.println("外部类成员变量"+Outer.this.num);//外部类成员变量,10
        }
    }
}
