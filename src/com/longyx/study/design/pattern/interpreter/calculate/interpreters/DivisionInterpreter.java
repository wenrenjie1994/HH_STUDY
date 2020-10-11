package com.longyx.study.design.pattern.interpreter.calculate.interpreters;

import com.longyx.study.design.pattern.interpreter.calculate.ArithmeticInterpreter;
import com.longyx.study.design.pattern.interpreter.calculate.Interpreter;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 17:43
 */
public class DivisionInterpreter extends Interpreter {

    public DivisionInterpreter(ArithmeticInterpreter left, ArithmeticInterpreter right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() / this.right.interpret();
    }
}
