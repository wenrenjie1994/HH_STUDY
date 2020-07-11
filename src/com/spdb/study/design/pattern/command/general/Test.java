package com.spdb.study.design.pattern.command.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 14:38
 */
public class Test {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.handle();
    }
}
