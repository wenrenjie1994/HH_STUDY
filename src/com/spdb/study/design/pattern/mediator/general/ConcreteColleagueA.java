package com.spdb.study.design.pattern.mediator.general;

/**
 * 具体同事类
 * @author Mr.Longyx
 * @date 2020年07月12日 11:19
 */
public class ConcreteColleagueA extends Colleague{
    public ConcreteColleagueA(Meditor mediator) {
        super(mediator);
        this.mediator.setColleagueA(this);
    }
    /**
     * 自有方法
     * @author Mr.Longyx
     * @date 2020/7/12 11:22
     */
    public void selfMethodA(){
        /**
         * 处理自己部分的逻辑
         * @author Mr.Longyx
         * @date 2020/7/12 11:22
         */
        System.out.println(String.format("%s:self-Method", this.getClass().getSimpleName()));
    }

    /**
     * 依赖方法
     * @author Mr.Longyx
     * @date 2020/7/12 11:23
     */
    public void depMethodA(){
        System.out.println(String.format("%s:dep-Method:delegate to Meditor",this.getClass().getSimpleName()));
        /**
         * 无法处理的业务逻辑委托给中介者处理
         * @author Mr.Longyx
         * @date 2020/7/12 11:25
         */
        this.mediator.transferA();
    }

}
