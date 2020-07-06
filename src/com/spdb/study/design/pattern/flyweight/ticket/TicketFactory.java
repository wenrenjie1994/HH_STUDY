package com.spdb.study.design.pattern.flyweight.ticket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年07月05日 23:49
 */
public class TicketFactory {
    private static Map<String,Ticket> pool = new HashMap<>();

    public static Ticket queryTicket(String from, String to){
        String key = from + "->"+to;
        if (pool.containsKey(key)){
            System.out.println("使用缓存："+key);
            return pool.get(key);
        }
        System.out.println("首次查询，创建对象；"+key);

        Ticket ticket = new TrainTicket(from,to);
        pool.put(key,ticket);
        return ticket;
    }
}
