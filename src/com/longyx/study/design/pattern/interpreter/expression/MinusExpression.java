package com.longyx.study.design.pattern.interpreter.expression;

/**
 * 自减操作
 * @author Mr.Longyx
 * @date 2020年07月12日 19:53
 */
public class MinusExpression extends Expression{

    @Override
    public void interpret(Context context) {
        System.out.println("自动递减");

        String input = context.getInput();

        Integer value = Integer.valueOf(input);

        --value;

        context.setInput(String.valueOf(value));
        context.setOutput(value);
    }
}
