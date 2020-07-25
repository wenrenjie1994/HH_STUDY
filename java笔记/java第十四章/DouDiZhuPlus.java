package basic.method.demo1.day12;

import java.util.*;

//有序版斗地主
public class DouDiZhuPlus {
    public static void main(String[] args) {
        //1.准备牌
        HashMap<Integer, String> poker = new HashMap<>();
        ArrayList<Integer> PokerIndex = new ArrayList<>();
        List<String> colors = List.of("♠", "♣", "♢", "♡");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        int index = 0;
        poker.put(index,"大王");
        PokerIndex.add(index);
        index++;
        poker.put(index,"小王");
        PokerIndex.add(index);
        index++;

        for (String number : numbers) {
            for (String color : colors) {
                poker.put(index,color+number);
                PokerIndex.add(index);
                index++;
            }
        }
     //2.洗牌
        Collections.shuffle(PokerIndex);

        //3.发牌
        ArrayList<Integer> player1 = new ArrayList<>();
        ArrayList<Integer> player2 = new ArrayList<>();
        ArrayList<Integer> player3 = new ArrayList<>();
        ArrayList<Integer> dipai = new ArrayList<>();

        for (int i = 0; i < PokerIndex.size(); i++) {
            Integer in = PokerIndex.get(i);
            if (i>=51){
                dipai.add(in);
            }else if (i%3==0){
                player1.add(in);
            }else if (i%3==1){
                player2.add(in);
            }else {
                player3.add(in);
            }
        }

        //4.排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(dipai);
        lookPoker("小刘",poker,player1);
        lookPoker("小梁",poker,player2);
        lookPoker("小王",poker,player3);
        lookPoker("底牌",poker,dipai);

        //5.看牌
    }
    public static void lookPoker(String name,HashMap<Integer, String> poker,ArrayList<Integer> list){
        System.out.print(name+": ");
        for (Integer key : list) {
            String value = poker.get(key);
            System.out.print(value+" ");
        }
        System.out.println();

    }
}
