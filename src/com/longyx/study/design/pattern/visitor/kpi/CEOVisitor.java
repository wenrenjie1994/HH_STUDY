package com.spdb.study.design.pattern.visitor.kpi;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:21
 */
public class CEOVisitor implements Visitor {
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师： "+engineer.name+", KPI: "+engineer.kpi);
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理： "+manager.name+", KPI: "+manager.kpi+"，产品数量： "+manager.getProducts());
    }
}
