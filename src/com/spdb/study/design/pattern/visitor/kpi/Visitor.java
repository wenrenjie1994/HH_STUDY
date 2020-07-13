package com.spdb.study.design.pattern.visitor.kpi;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 22:07
 */
public interface Visitor {
    void visit(Engineer engineer);
    void visit(Manager manager);
}
