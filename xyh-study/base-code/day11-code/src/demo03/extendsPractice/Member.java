package demo03.extendsPractice;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {

    }
    public Member(String name,int money){
        super(name,money);
    }

    public void receive(ArrayList<Integer> list){
        //从多个红包当中随便抽取一个给自己
        //随机获取一个集合当中的索引编号
        int index=new Random().nextInt(list.size());
        //根据集合当中删除，并且将被删除的红包给自己
        int deta=list.remove(index);
        int money=super.getMoney();
        super.setMoney(money+deta);
    }
}
