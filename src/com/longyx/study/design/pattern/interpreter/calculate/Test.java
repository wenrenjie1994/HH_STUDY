package com.spdb.study.design.pattern.interpreter.calculate;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 17:33
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("result: "+ new SpdbCalculator("10 + 50").calculate());

        System.out.println("result: "+new SpdbCalculator("100 * 2 + 400 * 1 + 66").calculate());
    }
}
