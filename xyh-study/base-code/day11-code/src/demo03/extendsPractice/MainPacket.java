package demo03.extendsPractice;

import java.util.ArrayList;

public class MainPacket {
    public static void main(String[] args) {
        Manager manager=new Manager("群主",100);
        Member one=new Member("成员A",0);
        Member two=new Member("成员B",0);
        Member three=new Member("成员C",0);

        manager.show();
        one.show();
        two.show();
        three.show();
        System.out.println("====================");

        ArrayList<Integer> redList=manager.send(20,3);
        one.receive(redList);
        three.receive(redList);
        two.receive(redList);

        manager.show();
        one.show();
        two.show();
        three.show();
    }
}
