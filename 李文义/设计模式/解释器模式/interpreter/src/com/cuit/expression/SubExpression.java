package com.cuit.expression;

import java.util.HashMap;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class SubExpression extends SymbolExpression {
    public SubExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    /**
     * 功能描述:
     * public SubExpression(Expression _left,Expression _right){
     * super(_left,_right);
     * }
     *
     * @param var 1
     * @return: int
     * @author: liwenyi
     */
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}
