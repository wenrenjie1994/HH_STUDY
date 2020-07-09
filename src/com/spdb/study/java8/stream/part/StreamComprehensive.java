package com.spdb.study.java8.stream.part;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * @author Mr.Longyx
 * @date 2020年07月07日 21:47
 */
public class StreamComprehensive {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Milan");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario,2012, 750),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 1024)
        );

        List<Transaction> list = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
        System.out.println(list);

        transactions.stream().map(t -> t.getTrader().getCity())
                .distinct().forEach(System.out::println);

        //获取所有Cambridge的trader
        transactions.stream().map(Transaction::getTrader)
                .filter(t->t.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        String value = transactions.stream().map(t->t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("",(name1,name2)->name1 + " "+ name2);
        System.out.println(value);

        //查找在米兰的trader
        boolean isMilan = transactions.stream().anyMatch(t->t.getTrader().getCity().equalsIgnoreCase("Milan"));
        boolean im = transactions.stream().map(Transaction::getTrader).anyMatch(t->t.getCity().equalsIgnoreCase("Milan"));
        System.out.println(isMilan == im);

        transactions.stream().filter(t->t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue).forEach(System.out::println);

       /**
        *  获取最大值
        * int maxValue =  transactions.stream().map(Transaction::getValue).reduce(Integer::max).get();
        * @author Mr.Longyx
        * @date 2020/7/7 22:21
        */

        Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).reduce((i,j)->i>j?i:j);
        System.out.println(maxValue.get());

        /**
         * 获取最小值
         * @author Mr.Longyx
         * @date 2020/7/7 22:23
         */
        int minValue = transactions.stream().map(Transaction::getValue).reduce(Integer::min).get();
        System.out.println(minValue);
    }
}
