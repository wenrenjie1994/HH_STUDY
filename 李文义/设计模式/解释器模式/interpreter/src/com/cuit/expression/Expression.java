package com.cuit.expression;

import java.util.HashMap;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public abstract class Expression {
    /**
     * 功能描述:
     * 解析公式和数值，其中var中的key值是公式中的参数，value值是具体的数字
     *
     * @param var 1
     * @return: int
     * @author: liwenyi
     */
    public abstract int interpreter(HashMap<String,Integer> var);
}
