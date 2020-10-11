package com.longyx.study.design.pattern.interpreter.calculate;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 17:37
 */
public class NumInterpreter implements ArithmeticInterpreter {
    private int value;

    public NumInterpreter(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
