package abs.demo02;

import java.util.ArrayList;

/**
 * @program: TODO
 * @className:Manager
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/31 16:18
 **/
public class Manager extends User{
    public Manager() {

    }

    public Manager(String name, int money) {
        super(name, money);
    }

    //群主发红包
    public ArrayList<Integer> send(int totalMoney, int count) {
        ArrayList<Integer> redList = new ArrayList<>();
        int leftMoney = super.getMoney();
        if(leftMoney < totalMoney) {
            System.out.println("余额不足！");
            return redList;
        }
        super.setMoney(leftMoney - totalMoney);
        int avg = totalMoney / count;
        int mod = totalMoney % count;
        for (int i = 0; i < count - 1 ; i++) {
            redList.add(avg);
        }
        //把剩下的钱放在最后一个红包
        redList.add(avg + mod);
        return redList;
    }
}
