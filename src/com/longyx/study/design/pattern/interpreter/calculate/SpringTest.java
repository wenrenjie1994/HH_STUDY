package com.spdb.study.design.pattern.interpreter.calculate;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Spring中SpelExpressionParser类即应用了解释器模式
 * @author Mr.Longyx
 * @date 2020年07月12日 18:14
 */
public class SpringTest {
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression("100 * 2 + 200 *3 + 100 + 33 * 3");
        Integer result = (Integer)expression.getValue();
        System.out.println("计算结果： "+result);

        expression = parser.parseExpression("888 + 666 * 9 + (30-3)/9 + 892");
        result = (Integer)expression.getValue();
        System.out.println("计算结果： "+result);
    }

}
