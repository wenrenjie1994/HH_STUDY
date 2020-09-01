package com.spdb.study.design.pattern.command.general;

/**
 * 命令请求者
 * @author Mr.Longyx
 * @date 2020年07月11日 14:34
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void handle(){
        this.command.execute();
    }
}
