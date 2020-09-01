package com.cuit.expression;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public abstract class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;
    /**
     * 功能描述:
     * 所有的解析公式都应只关心自己左右两个表达式的结果
     *
     * @param _left 1
     * @param _right 2
     * @return:
     * @author: liwenyi
     */
    public SymbolExpression(Expression _left,Expression _right){
        this.left = _left;
        this.right = _right;
    }
}
