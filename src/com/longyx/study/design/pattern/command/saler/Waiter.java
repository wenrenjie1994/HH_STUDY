package com.longyx.study.design.pattern.command.saler;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量处理订单
 * @author Mr.Longyx
 * @date 2020年07月11日 16:26
 */
public class Waiter {
    private List<Command> commands = new ArrayList<>();

    public void setOrder(Command command){
        commands.add(command);
    }
    
    public void sellFruits(){
        for (Command comm : commands){
            comm.sell();
        }
    }
    
    /**
     * 取消订单
     * @author Mr.Longyx
     * @date 2020/7/11 16:31
     */
    public void cancelOrder(Command command){
        commands.remove(command);
    }
}
