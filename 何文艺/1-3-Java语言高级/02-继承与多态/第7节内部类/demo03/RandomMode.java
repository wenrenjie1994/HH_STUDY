package day0802.innerClass.demo03;

import java.util.ArrayList;
import java.util.Random;

/*
手气红包：随机分配
范围公式：1 + random.nextInt(leftMoney / leftCount * 2)
 */
public class RandomMode implements OpenMode{

    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        int leftMoney = totalMoney;
        int leftCount = totalCount;
        for (int i = 0; i < totalCount - 1; i++) {
            int money = 1 + random.nextInt(leftMoney / leftCount * 2);
            list.add(money);
            leftMoney -= money;
            leftCount--;
        }
        list.add(leftMoney);
        return list;
    }
}
