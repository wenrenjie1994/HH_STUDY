package com.spdb.study.design.pattern.interpreter.expression;

import java.io.Serializable;

/**
 * 上下文环境类，用来保存文法
 * @author Mr.Longyx
 * @date 2020年07月12日 19:48
 */
public class Context implements Serializable {
    private static final long serialVersionUID = 8627980170460038239L;

    private String input;
    private int output;

    public Context(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Context{" +
                "input='" + input + '\'' +
                ", output=" + output +
                '}';
    }
}
