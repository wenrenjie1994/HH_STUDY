package com.longyx.study.design.pattern.chain.process;

/**
 * 顶层设计 对审批流程的抽象
 * @author Mr.Longyx
 * @date 2020年07月11日 0:02
 */
public abstract class Auditor {
    /**
     * 对审批人姓名的抽象
     * @author Mr.Longyx
     * @date 2020/7/11 0:13
     */
    protected String name;

    /**
     * 下一级审批人
     * @author Mr.Longyx
     * @date 2020/7/11 0:15
     */
    protected Auditor nextProcess;

    protected Auditor(String name) {
        this.name = name;
    }

    protected Auditor nextProcess(Auditor nextProcess){
        this.nextProcess = nextProcess;
        return this.nextProcess;
    }

    /**
     * 具体审批逻辑交由具体审批人子类实现
     * @author Mr.Longyx
     * @date 2020/7/11 0:23
     * @param amount
     */
    public abstract void audit(int amount);
}
