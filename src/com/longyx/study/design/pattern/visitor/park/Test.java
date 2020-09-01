package com.spdb.study.design.pattern.visitor.park;

/**
 * @author Mr.Longyx
 * @date 2020年07月13日 10:38
 */
public class Test {
    public static void main(String[] args) {
        Park park = new Park();
        park.setName("心怡公园");

        /**
         * 清洁工A
         * @author Mr.Longyx
         * @date 2020/7/13 10:40
         */
        VisitorA visitorA = new VisitorA();
        park.accept(visitorA);

        /**
         * 清洁工B
         * @author Mr.Longyx
         * @date 2020/7/13 10:40
         */
        System.out.println("====================");
        VisitorB visitorB = new VisitorB();
        park.accept(visitorB);
        
        /**
         * 管理员负责检查整片公园卫生
         * @author Mr.Longyx
         * @date 2020/7/13 10:41
         */
        System.out.println("===================");
        Manager manager = new Manager();
        park.accept(manager);
    }
}
