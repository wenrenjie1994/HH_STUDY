package com.spdb.study.design.pattern.chain.process;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 9:20
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 此处将审批逻辑交由客户端控制(不友好)
         * Auditor auditor = new Staff("cafebabe");
         *
         *  auditor.nextProcess(new Manager("komi")).nextProcess(new CEO("Michael"));
         *
         *  auditor.audit(8888);
         *
         *  System.out.println("==================================");
         *  auditor.audit(15000);
         *
         *  System.out.println("===================================");
         *  auditor.audit(90000);
         *
         *  System.out.println("====================================");
         *  auditor.audit(120000);
         * @author Mr.Longyx
         * @date 2020/7/11 9:48
         */

        /**
         * 优化实现
         * @author Mr.Longyx
         * @date 2020/7/11 9:53
         */
        ProcessService service = new ProcessService();
        service.processHandler("cafebabe",8888);

        System.out.println("====================================");
        service.processHandler("cafebabe",15000);

        System.out.println("====================================");
        service.processHandler( "cafebabe",90000);

        System.out.println("====================================");
        service.processHandler("cafebabe",120000);
    }
}
