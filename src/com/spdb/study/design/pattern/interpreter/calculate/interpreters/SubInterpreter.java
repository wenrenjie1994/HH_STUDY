package com.spdb.study.design.pattern.interpreter.calculate.interpreters;

import com.spdb.study.design.pattern.interpreter.calculate.ArithmeticInterpreter;
import com.spdb.study.design.pattern.interpreter.calculate.Interpreter;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 17:41
 */
public class SubInterpreter extends Interpreter {
    public SubInterpreter(ArithmeticInterpreter left, ArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }
}
