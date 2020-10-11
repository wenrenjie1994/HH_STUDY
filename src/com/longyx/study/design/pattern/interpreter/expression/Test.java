package com.longyx.study.design.pattern.interpreter.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 19:56
 */
public class Test {
    public static void main(String[] args) {

        Context context = new Context("10");

        List<Expression> list = new ArrayList<>();
        list.add(new PlusExpression());
        list.add(new MinusExpression());

        for (Expression e : list){
            e.interpret(context);
            System.out.println(context.getOutput());
        }
    }
}
