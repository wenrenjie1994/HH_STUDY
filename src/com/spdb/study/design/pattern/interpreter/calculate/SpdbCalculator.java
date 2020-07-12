package com.spdb.study.design.pattern.interpreter.calculate;

import java.util.Stack;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 17:32
 */
public class SpdbCalculator {
    private Stack<ArithmeticInterpreter> stack = new Stack<>();

    public SpdbCalculator(String expression){
        parse(expression);
    }

    private void parse(String expression) {
        String[] eles = expression.split(" ");
        ArithmeticInterpreter left,right;

        for (int i = 0; i < eles.length; i++) {
            String operator = eles[i];
            if (OperatorUtil.isOperator(operator)){
                left = this.stack.pop();
                right = new NumInterpreter(Integer.valueOf(eles[++i]));
                System.out.println("出栈： "+left.interpret()+"和"+right.interpret());
                this.stack.push(OperatorUtil.getInterpreter(left,right,operator));
                System.out.println("应用运算符： "+operator);
            }else {
                NumInterpreter numInterpreter = new NumInterpreter(Integer.valueOf(eles[i]));
                this.stack.push(numInterpreter);
                System.out.println("入栈： "+numInterpreter.interpret());
            }
        }
    }

    public int calculate(){
        return this.stack.pop().interpret();
    }
}
