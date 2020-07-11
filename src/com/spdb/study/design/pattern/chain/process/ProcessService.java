package com.spdb.study.design.pattern.chain.process;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 9:42
 */
public class ProcessService {

    public void processHandler(String name,int amount){
        Staff staff = new Staff(name);
        Manager manager = new Manager("komi");
        CEO ceo = new CEO("Michael");

        staff.nextProcess(manager).nextProcess(ceo);

        staff.audit(amount);
    }
}
