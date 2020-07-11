package com.spdb.study.design.pattern.state.general.apply;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 19:37
 */
public class Test {
    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new ConcreteStateA());
        context.handle();
    }
}
