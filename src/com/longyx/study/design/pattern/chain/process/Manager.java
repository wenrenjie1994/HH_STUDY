package com.spdb.study.design.pattern.chain.process;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 9:14
 */
public class Manager extends Auditor {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void audit(int amount) {
        if (amount <= 50000){
            System.out.println("审批通过。 【经理： "+name+"】 ");
        }else {
            System.out.println("无权审批，升级处理。 【经理： "+name+"】 ");
            this.nextProcess.audit(amount);
        }
    }
}
