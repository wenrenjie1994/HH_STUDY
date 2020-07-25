package fu.day04.demo03;

//定义一个类，用来模拟’手机‘事物。
/*属性：品牌，价格，颜色
行为：打电话，发短信

对应到类当中
成员变量（属性）：
String brand;
double price;
String color

成员函数（行为）：
public void call(Strng who){}
public void sendMessage(){}
*/

public class Phone {
    String brand;
    double price;
    String color;

    public void call(String who){
        System.out.println("给"+who+"打电话");

    }
    public void sendMessage(){
        System.out.println("q群发短信");
    }

}
