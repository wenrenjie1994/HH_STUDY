package com.spdb.study.design.pattern.visitor.general;

/**
 * 具体元素
 * @author Mr.Longyx
 * @date 2020年07月12日 21:12
 */
public class ConcreteElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA(){
        return this.getClass().getSimpleName();
    }
}
