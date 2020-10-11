package com.longyx.study.design.pattern.interpreter.calculate;

/**
 * 非终结表达式
 * @author Mr.Longyx
 * @date 2020年07月12日 17:38
 */
public abstract class Interpreter implements ArithmeticInterpreter {
    protected ArithmeticInterpreter left;
    protected ArithmeticInterpreter right;

    public Interpreter(ArithmeticInterpreter left, ArithmeticInterpreter right) {
        this.left = left;
        this.right = right;
    }
}
