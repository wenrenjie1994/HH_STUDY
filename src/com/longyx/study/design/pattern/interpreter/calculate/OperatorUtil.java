package com.longyx.study.design.pattern.interpreter.calculate;

import com.longyx.study.design.pattern.interpreter.calculate.interpreters.*;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 17:47
 */
public class OperatorUtil {
    public static boolean isOperator(String symbol){
        return symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/") || symbol.equals("%");
    }

    public static Interpreter getInterpreter(ArithmeticInterpreter left, ArithmeticInterpreter right, String symbol) {
        if (symbol.equals("+")){
            return new AddInterpreter(left, right);
        }else if(symbol.equals("-")){
            return new SubInterpreter(left, right);
        }else if (symbol.equals("*")) {
            return new MultiInterpreter(left, right);
        }else if (symbol.equals("/")){
            return new DivisionInterpreter(left, right);
        }else if (symbol.equals("%")){
            return new BalanceInterpreter(left, right);
        }
        return null;
    }
}
