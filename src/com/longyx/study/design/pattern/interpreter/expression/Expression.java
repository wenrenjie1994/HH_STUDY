package com.spdb.study.design.pattern.interpreter.expression;

/**
 * 顶层抽象解释器
 * @author Mr.Longyx
 * @date 2020年07月12日 19:46
 */
public abstract class Expression {
    public abstract void interpret(Context context);
}
