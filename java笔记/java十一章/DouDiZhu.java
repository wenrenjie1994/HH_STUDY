package basic.method.demo1.day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DouDiZhu {
    public static void main(String[] args) {
        //1.准备牌
        //定义一个存储54张牌的集合
        ArrayList<String> poker =  new ArrayList<>();
        //定义两个数组，一个数组存储牌的花色，一个数组存储牌的序号
        String[] colors = {"♠","♣","♢","♡"};
        String[] numbers = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        poker.add("大王");
        poker.add("小王");
        //循环嵌套遍历两个数组，组装52张牌
        for (String number:numbers){
            for (String color : colors) {
                poker.add(color+number);
            }
        }
        //2.洗牌，用collections的方法static viod shuffle(list<?>list),使用默认随机源对指定列表进行置换
        Collections.shuffle(poker);
//        System.out.println(poker);

        //3.发牌
        //定义4个集合，存储玩家的牌和底牌
        ArrayList<String> play1 = new ArrayList<>();
        ArrayList<String> play2 = new ArrayList<>();
        ArrayList<String> play3 = new ArrayList<>();
        ArrayList<String> dipai = new ArrayList<>();
        /*
        遍历poker集合，获取每一张牌
        使用poker集合的索引%3，给3个玩家轮流发牌
        剩余3张给底牌
         */
        for (int i = 0; i < poker.size(); i++) {
            String p = poker.get(i);
            if (i>=51){
                dipai.add(p);
            }
            //如果索引%3=0，给玩家1发牌
            else if (i%3==0){
                play1.add(p);
            }
            else if (i%3==1){
                play2.add(p);
            }
            else {
                play3.add(p);
            }

        }
        //4.看牌
        System.out.println("刘："+play1);
        System.out.println("梁："+play2);
        System.out.println("王："+play3);
        System.out.println("底牌为："+dipai);
    }
}
