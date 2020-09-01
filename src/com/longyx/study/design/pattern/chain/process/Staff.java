package com.spdb.study.design.pattern.chain.process;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 0:26
 */
public class Staff extends Auditor{
    public Staff(String name) {
        super(name);
    }

    @Override
    public void audit(int amount) {
        if (amount <= 10000){
            System.out.println("审批通过。 【员工："+name+"】 ");
        }else {
            System.out.println("无权审批，升级处理。 【员工： "+name+"】 ");
            this.nextProcess.audit(amount);
        }
    }
}
