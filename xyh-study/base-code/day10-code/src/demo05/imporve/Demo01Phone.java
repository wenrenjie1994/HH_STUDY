package demo05.imporve;
/*
继承中方法的重写覆盖
设计原则：
对于已经投入使用的类，尽量不要进行修改。
推荐定义一个新的类，来重复利用其中共性内容，并且添加改动新内容
* */
public class Demo01Phone {
    public static void main(String[] args) {
        //老款手机
        Phone phone=new Phone();
        phone.call();
        phone.send();
        phone.show();
        System.out.println("==================");

        //新款手机
        NewPhone newPhone=new NewPhone();
        newPhone.call();
        newPhone.send();
        newPhone.show();
    }
}
