package com.spdb.study.design.pattern.state.general.simple;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 18:01
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateB());

        context.handle();
    }
}
