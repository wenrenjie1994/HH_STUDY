package fu.day04.demo03;
//当新建对象时，成员变量在堆中创建变量，
//成员方法，存储了方法区中成员函数的地址
public class Demo01PhoneOne {
    public static void main(String[] args) {
        //创建对象
        //格式：类名称 对象名=new 类名称（）；
        Phone one=new Phone();
        System.out.println(one.brand);//null
        System.out.println(one.color);//null
        System.out.println(one.price);//0.0

        one.brand="苹果";
        one.color="黑色";
        one.price=8000;

        System.out.println(one.brand);//
        System.out.println(one.color);//
        System.out.println(one.price);//

        one.call("乔布斯");
        one.sendMessage();



    }
}
