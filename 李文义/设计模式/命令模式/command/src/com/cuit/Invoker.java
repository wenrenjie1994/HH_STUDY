package com.cuit;

import com.cuit.command.Command;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Invoker {
    /**
     * 功能描述:
     * 什么命令
     *
     * @author: liwenyi
     */
    private Command command;

    public void setCommand(Command command){
        this.command = command;
    }

    /**
     * 功能描述:
     * 执行客户的命令
     *
     * @return: void
     * @author: liwenyi
     */
    public void action(){
        this.command.execute();
    }
}
