package abs.demo02;

import java.util.ArrayList;
import java.util.Random;

/**
 * @program: TODO
 * @className:Member
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/31 16:28
 **/
public class Member extends User{
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> list) {
        //随机抽取
        int index = new Random().nextInt(list.size());
        super.setMoney(super.getMoney() + list.remove(index));

    }
}
