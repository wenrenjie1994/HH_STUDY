package com.cuit.expression;

import java.util.HashMap;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class VarExpression extends Expression {
    private String key;
    public VarExpression(String _key){
        this.key = _key;
    }
    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}
