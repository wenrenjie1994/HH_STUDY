package com.spdb.study.design.pattern.visitor.kpi;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:30
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 获得报表
         * @author Mr.Longyx
         * @date 2020/7/12 22:31
         */
        BusinessReport report = new BusinessReport();
        System.out.println("==========CEO查看报表=============");
        report.showReport(new CEOVisitor());

        System.out.println("===========CTO查看报表=============");
        report.showReport(new CTOVisitor());
    }
}
