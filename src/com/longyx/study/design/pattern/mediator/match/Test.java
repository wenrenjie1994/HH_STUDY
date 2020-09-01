package com.spdb.study.design.pattern.mediator.match;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 16:24
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 引入中介者
         * @author Mr.Longyx
         * @date 2020/7/12 16:24
         */
        Meditor meditor = new Meditor();
        /**
         * 指定男孩和女孩
         * @author Mr.Longyx
         * @date 2020/7/12 16:25
         */
        Colleague zs = new Boy("张三",80,meditor);
        Colleague ls = new Boy("李四",85,meditor);

        Colleague xm = new Girl("小敏",80,meditor);

        zs.findTheHalf(xm);
    }
}
