package com.spdb.study.design.pattern.chain.process;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 9:18
 */
public class CEO extends Auditor {
    public CEO(String name) {
        super(name);
    }

    @Override
    public void audit(int amount) {
        if (amount < 100000){
            System.out.println("审批通过。 【CEO： "+name+"】 ");
        }else {
            System.out.println("驳回申请。 【CEO： "+name+"】 ");
        }
    }
}
