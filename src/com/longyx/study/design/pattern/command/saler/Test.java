package com.longyx.study.design.pattern.command.saler;

import com.longyx.study.design.pattern.command.saler.commands.AppleCommand;
import com.longyx.study.design.pattern.command.saler.commands.BananaCommand;
import com.longyx.study.design.pattern.command.saler.commands.GrapeCommand;
import com.longyx.study.design.pattern.command.saler.commands.OrangeCommand;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 16:33
 */
public class Test {
    public static void main(String[] args) {
        Saler saler = new Saler();
        Command apple = new AppleCommand(saler);
        Command grape = new GrapeCommand(saler);
        Command orange = new OrangeCommand(saler);
        Command banana = new BananaCommand(saler);

        Waiter waiter = new Waiter();
        waiter.setOrder(apple);
        waiter.setOrder(grape);
        waiter.setOrder(orange);
        waiter.setOrder(banana);

        waiter.sellFruits();

        /**
         * 取消某个水果出售
         * @author Mr.Longyx
         * @date 2020/7/11 16:49
         */
        waiter.cancelOrder(grape);

        System.out.println("============");
        waiter.sellFruits();
    }
}
