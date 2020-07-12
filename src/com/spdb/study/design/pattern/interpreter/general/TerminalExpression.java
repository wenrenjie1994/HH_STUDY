package com.spdb.study.design.pattern.interpreter.general;

/**
 * 终结符表达式
 * @author Mr.Longyx
 * @date 2020年07月12日 17:11
 */
public class TerminalExpression implements Expression{
    private Object value;

    @Override
    public Object interpret(Context context) {
        /**
         * 实现与文法中与终结符有关的操作
         * @author Mr.Longyx
         * @date 2020/7/12 17:14
         * @param context
         * @return java.lang.Object
         */
        context.put("","");
        return null;
    }
}
