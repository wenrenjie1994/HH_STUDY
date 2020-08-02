package demo;

import java.lang.reflect.Member;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("群主",100);

        Number one = new Number("成员A",0);
        Number two = new Number("成员B",0);
        Number three = new Number("成员C",0);

        manager.show();
        one.show();
        two.show();
        three.show();
        System.out.println("===========");

        //群主总共发20块钱，分成3个红包
        ArrayList<Integer> redList = manager.send(20,3);
        //三个普通成员收红包
        one.receive(redList);
        two.receive(redList);
        three.receive(redList);

        manager.show();//100-20=80
        //6,6,8,随机分给三个人
        one.show();
        two.show();
        three.show();
    }
}
