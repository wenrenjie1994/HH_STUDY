package com.spdb.study.design.pattern.mediator.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 12:49
 */
public class Test {
    public static void main(String[] args) {
        Meditor meditor = new ConcreteMeditor();

        ConcreteColleagueA colleagueA = new ConcreteColleagueA(meditor);
        ConcreteColleagueB colleagueB = new ConcreteColleagueB(meditor);

        colleagueA.depMethodA();

        System.out.println("=================================================");
        colleagueB.depMethodB();
    }
}
