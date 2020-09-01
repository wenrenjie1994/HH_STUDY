package com.spdb.study.design.pattern.visitor.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 21:24
 */
public class ConcreteVisitorB  implements Visitor{
    @Override
    public void visit(ConcreteElementA element) {
        String result = element.operationA();
        System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
    }

    @Override
    public void visit(ConcreteElementB element) {
        int result = element.operationB();
        System.out.println("result from " + element.getClass().getSimpleName() + ": " + result);
    }
}
