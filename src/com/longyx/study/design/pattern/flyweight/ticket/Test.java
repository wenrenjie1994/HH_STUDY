package com.spdb.study.design.pattern.flyweight.ticket;


/**
 * @author Mr.Longyx
 * @date 2020年07月05日 23:53
 */
public class Test {
    public static void main(String[] args) {
        Ticket ticket = TicketFactory.queryTicket("北京西","成都");
        ticket.showInfo("硬座");

        ticket = TicketFactory.queryTicket("北京西","成都");
        ticket.showInfo("软座");

        ticket = TicketFactory.queryTicket("北京西","成都西");
        ticket.showInfo("软卧");
    }
}
