package abs.demo02;

import javax.swing.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * @program: TODO
 * @className:Test
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/31 16:34
 **/
public class Test {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 100);
        Member memberA = new Member("成员A",0);
        Member memberB = new Member("成员B",0);
        Member memberC = new Member("成员C",0);

        manager.show();
        memberA.show();
        memberB.show();
        memberC.show();
        System.out.println("=================");

        ArrayList<Integer> redList = manager.send(20, 3);
        memberA.receive(redList);
        memberB.receive(redList);
        memberC.receive(redList);

        manager.show();
        memberA.show();
        memberB.show();
        memberC.show();
    }
}
