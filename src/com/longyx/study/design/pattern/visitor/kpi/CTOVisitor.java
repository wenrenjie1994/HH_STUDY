package com.spdb.study.design.pattern.visitor.kpi;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:18
 */
public class CTOVisitor implements Visitor{
    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师： "+engineer.name+"，代码行数： "+engineer.getCodeLines());
    }

    @Override
    public void visit(Manager manager) {
        System.out.println("经理： "+manager.name+"产品数量： "+manager.getProducts());
    }
}
