package com.longyx.study.design.pattern.interpreter.expression;

/**
 * 自加操作
 * @author Mr.Longyx
 * @date 2020年07月12日 19:50
 */
public class PlusExpression extends Expression{

    @Override
    public void interpret(Context context) {
        /**
         * 给定提示信息
         * @author Mr.Longyx
         * @date 2020/7/12 19:50
         * @param context
         */
        System.out.println("自动递增");
        /**
         * 获取上下文环境
         * @author Mr.Longyx
         * @date 2020/7/12 19:51
         * @param context
         */
        String input = context.getInput();
        Integer value = Integer.valueOf(input);

        /**
         * 进行递增
         * @author Mr.Longyx
         * @date 2020/7/12 19:52
         * @param context
         */
        ++value;

        /**
         * 对上下文环境重新赋值
         * @author Mr.Longyx
         * @date 2020/7/12 19:52
         * @param context
         */
        context.setInput(String.valueOf(value));
        context.setOutput(value);
    }
}
