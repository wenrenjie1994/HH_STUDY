package com.spdb.study.design.pattern.visitor.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 21:25
 */
public class Test {
    public static void main(String[] args) {
        ObjectStructure collection = new ObjectStructure();
        System.out.println("ConcreteVisitorA handle elements:");
        Visitor visitorA = new ConcreteVisitorA();
        collection.accept(visitorA);

        System.out.println("=================================");
        System.out.println("ConcreteVisitorB handle elements:");
        Visitor visitorB = new ConcreteVisitorB();
        collection.accept(visitorB);
    }
}
