package com.spdb.study.design.pattern.mediator.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 12:37
 */
public class ConcreteColleagueB extends Colleague{
    public ConcreteColleagueB(Meditor mediator) {
        super(mediator);
        this.mediator.setColleagueB(this);
    }

    public void selfMethodB(){
        System.out.println(String.format("%s:self-Method", this.getClass().getSimpleName()));
    }

    public void depMethodB(){
        System.out.println(String.format("%s:depMethod: delegate to Meditor", this.getClass().getSimpleName()));
        this.mediator.transferB();
    }
}
