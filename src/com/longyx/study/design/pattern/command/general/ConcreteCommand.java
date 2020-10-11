package com.longyx.study.design.pattern.command.general;

/**
 * 具体命令
 * @author Mr.Longyx
 * @date 2020年07月11日 14:37
 */
public class ConcreteCommand implements Command{
    /**
     * 直接创建接收者，不暴露给客户端
     * @author Mr.Longyx
     * @date 2020/7/11 14:38
     */
    private Receiver receiver = new Receiver();

    @Override
    public void execute() {
        this.receiver.handle();
    }
}
