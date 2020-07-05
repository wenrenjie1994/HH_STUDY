package com.spdb.study.design.pattern.facade.general;

/**
 * 门面模式通用实现方式
 * @author Mr.Longyx
 * @date 2020年07月05日 18:24
 */
public class Facade {
    private SubSystemA systemA;
    private SubSystemB systemB;
    private SubSystemC systemC;

    public Facade(){
        systemA = new SubSystemA();
        systemB = new SubSystemB();
        systemC = new SubSystemC();
    }
    /**
     * 整合多个系统统一对外提供服务
     * @author Mr.Longyx
     * @date 2020/7/5 18:37
     */
    public void doService(){
        systemA.doA();
        systemB.doB();
        systemC.doC();
    }
}
