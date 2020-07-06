package com.spdb.study.design.pattern.flyweight.ticket;
import	java.util.Random;

/**
 * @author Mr.Longyx
 * @date 2020年07月05日 23:43
 */
public class TrainTicket implements Ticket {
    private String from;
    private String to;
    private Integer price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println(from + "->"+to +":"+bunk+"价格："+ this.price );
    }
}
