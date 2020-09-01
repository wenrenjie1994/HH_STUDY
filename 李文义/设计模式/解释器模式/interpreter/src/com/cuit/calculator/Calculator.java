package com.cuit.calculator;

import com.cuit.expression.AddExpression;
import com.cuit.expression.Expression;
import com.cuit.expression.SubExpression;
import com.cuit.expression.VarExpression;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class Calculator {
    /**
     * 功能描述:
     * 定义表达式
     *
     * @author: liwenyi
     */
    private Expression expression;

    /**
     * 功能描述:
     * 构造函数传参，并解析
     *
     * @param expStr 1
     * @author: liwenyi
     */
    public Calculator(String expStr) {
        //定义一个栈，安排运算的先后顺序
        Stack<Expression> stack = new Stack<Expression>();
        //表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();
        //运算
        Expression left = null;
        Expression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                //加法
                case '+':
                    //加法结果放到栈中
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default: //公式中的变量
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        //把运算结果抛出来
        this.expression = stack.pop();
    }

    /**
     * 功能描述:
     * 开始运算
     *
     * @param var 1
     * @return: int
     * @author: liwenyi
     */
    public int run(HashMap<String, Integer> var) {
        return this.expression.interpreter(var);
    }
}
