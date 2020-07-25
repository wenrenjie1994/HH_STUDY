package fu.day04.demo03;

public class PhoneParam {
    public static void main(String[] args) {
        Phone one=new Phone();
        one.brand="苹果";
        one.price=3999.0;
        one.color="蓝色";
        method(one);//传递进去的参数其实就是对象的地址值

    }
    public static void method(Phone param){
        System.out.println(param.brand);//苹果
        System.out.println(param.color);//蓝色
        System.out.println(param.price);//3999.0
    }
}
