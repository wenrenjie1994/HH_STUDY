package com.longyx.study.design.pattern.visitor.general;

import java.util.ArrayList;
import java.util.List;

/**
 * 结构对象
 * @author Mr.Longyx
 * @date 2020年07月12日 21:17
 */
public class ObjectStructure {
    private List<Element> list = new ArrayList<>();

    {
        this.list.add(new ConcreteElementA());
        this.list.add(new ConcreteElementB());
    }

    public void accept(Visitor visitor){
        for (Element element : list) {
            element.accept(visitor);
        }
    }
}
