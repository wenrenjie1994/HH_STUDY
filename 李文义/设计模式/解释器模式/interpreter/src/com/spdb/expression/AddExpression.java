package com.spdb.expression;

import java.util.HashMap;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class AddExpression extends SymbolExpression {
    /**
     * 功能描述:
     * 所有的解析公式都应只关心自己左右两个表达式的结果
     *
     * @param _left  1
     * @param _right 2
     * @return:
     * @author: liwenyi
     */
    public AddExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    /**
     * 功能描述:
     * 把左右两个表达式运算的结果加起来
     *
     * @param var 1
     * @return: int
     * @author: liwenyi
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}
