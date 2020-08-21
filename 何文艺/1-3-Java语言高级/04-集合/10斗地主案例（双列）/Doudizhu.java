package day0812;

import java.util.*;

/**
 * @program: TODO
 * @className:Doudizhu
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/8/12 9:15
 **/
public class Doudizhu {
    public static void main(String[] args) {
        HashMap<Integer, String> cardsMap = new HashMap<>();//牌
        ArrayList<Integer> index = new ArrayList<>();//牌的索引

        //1.准备牌
        String[] colors = {"♥","♠","♣","♦"};//花色
        String[] numbers = {"2","A","k","Q","J","10","9","8","7","6","5","4","3"};//数字
        int count = 0;
        index.add(count);
        cardsMap.put(count++, "大王");
        index.add(count);
        cardsMap.put(count++, "小王");
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                index.add(count);
                cardsMap.put(count++, colors[i] + numbers[j]);
            }
        }
        System.out.println("当前生成的一副新牌为：");
        System.out.println(cardsMap);
        System.out.println("\n======================================================");

        //2.洗牌
        Collections.shuffle(index);

        //3.发牌
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();
        for (int i = 0; i < index.size(); i++) {
            if(i >= 51) {
                dipai.add(index.get(i));
            } else {
                switch (i % 3) {
                    case 0:
                        player01.add(index.get(i));
                        break;
                    case 1:
                        player02.add(index.get(i));
                        break;
                    case 2 :
                        player03.add(index.get(i));
                        break;
                }
            }
        }
        //4.排序
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(dipai);

        //5.看牌
        System.out.println("玩家1：");
        printCards(player01, cardsMap);
        System.out.println("\n玩家2：");
        printCards(player02, cardsMap);
        System.out.println("\n玩家3：");
        printCards(player03, cardsMap);
        System.out.println("\n底牌：");
        printCards(dipai, cardsMap);
    }

    public static void printCards(ArrayList<Integer> player, HashMap<Integer, String> cardsMap) {
        for (int i = 0; i < player.size(); i++) {
            System.out.print(cardsMap.get(player.get(i)) + " ");
        }
    }
}
