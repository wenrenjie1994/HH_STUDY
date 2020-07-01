package com.spdb.study.design.pattern.proxy.staticproxy;

/**
 * 静态代理的方式(不符合开闭原则)
 * @author Mr.Longyx
 * @date 2020年06月26日 20:28
 */
public class Mother {
    private  Son son;

    public Mother(Son son){
        this.son = son;
    }

    public void findLove(){
        System.out.println("母亲物色对象");
        this.son.findLove();
        System.out.println("双方父母同意，双方确立关系");
    }
}
