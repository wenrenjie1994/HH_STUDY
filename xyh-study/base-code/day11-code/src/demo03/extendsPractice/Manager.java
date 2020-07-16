package demo03.extendsPractice;

import java.util.ArrayList;


public class Manager extends User{
    public Manager(){

    }

    public Manager(String name, int money) {
        super(name, money);
    }
    public ArrayList<Integer> send(int totalMoney, int count){
        //需要一个集合，用来存储若干个红包
        ArrayList<Integer> redList=new ArrayList<>();
        int leftMoney=super.getMoney();//查看群主当前的余额
        if(totalMoney>leftMoney){
            System.out.println("余额不足");
            return redList;
        }
        //扣钱
        super.setMoney(leftMoney-totalMoney);
        //发红包
        int avg=totalMoney/count;
        int mod=totalMoney%count;//零头
        //零头放在最后一个红包中

        //放红包
        for (int i = 0; i < count-1; i++) {
            redList.add(avg);
        }
        int last=avg+mod;
        redList.add(last);
        return redList;
    }
}
