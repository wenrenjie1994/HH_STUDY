package com.spdb.study.design.pattern.visitor.general;

/**
 * 具体访问者
 * @author Mr.Longyx
 * @date 2020年07月12日 21:21
 */
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        String result = elementA.operationA();
        System.out.println("result from "+elementA.getClass().getSimpleName() + ": "+result);
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        int result = elementB.operationB();
        System.out.println("result from "+elementB.getClass().getSimpleName() + ": "+result);
    }
}
