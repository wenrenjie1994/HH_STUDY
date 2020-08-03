package day0802.innerClass.demo03;

import java.util.ArrayList;

/**
 * @program: TODO
 * @className:RedPacket
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/8/3 9:14
 **/
public class RedPacket {
    public static void main(String[] args) {
        System.out.println("10元3个的普通红包：");
        ArrayList<Integer> list1 = new NormalMode().divide(10,3);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("第" + i + "个红包：" + list1.get(i));
        }
        System.out.println("================");
        System.out.println("10元4个的手气红包：");
        ArrayList<Integer> list2 = new RandomMode().divide(10,4);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println("第" + i + "个红包：" + list2.get(i));
        }
    }
}
