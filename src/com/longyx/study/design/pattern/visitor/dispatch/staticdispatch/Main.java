package com.spdb.study.design.pattern.visitor.dispatch.staticdispatch;

/**
 * 静态分派(编译期间便确定了元素类型)
 * @author Mr.Longyx
 * @date 2020年07月12日 22:39
 */
public class Main {
    public void test(String symbol){
        System.out.println("String: "+symbol);
    }

    public void test(Integer integer){
        System.out.println("Integer: "+integer);
    }

    public static void main(String[] args) {
        String symbol = "1";
        Integer integer = 1;

        Main main = new Main();
        main.test(integer);
        main.test(symbol);
    }
}
