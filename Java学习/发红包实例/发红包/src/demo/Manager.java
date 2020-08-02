package demo;

import java.util.ArrayList;

//群主的类
public class Manager extends User {

    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    //发红包
    public ArrayList<Integer> send(int totalMoney, int count){
        //首先需要集合，用来存储若干个红包的金额
        ArrayList<Integer> resList = new ArrayList<>();

        //查看余额，是否够发红包
        int leftMoney = super.getMoney();
        if(totalMoney > leftMoney){
            System.out.println("余额不足");
            return resList; //返回空集合
        }

        //扣钱，其实就是重新设置金额
        super.setMoney(leftMoney-totalMoney);

        //发红包需要平均拆分成count份
        int avg = totalMoney/count;
        int mod = totalMoney%count;//余数，也就是甩下的零头

        //除不开的零头，包在最后一个红包中
        //下面把红包一个一个放到集合中
        for (int i = 0; i <count -1 ; i++) {
            resList.add(avg);
        }

        //最后一个红包
        int last = avg + mod;
        resList.add(last);

        return resList;

    }
}
