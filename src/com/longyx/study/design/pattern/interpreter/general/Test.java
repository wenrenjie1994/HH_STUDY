package com.longyx.study.design.pattern.interpreter.general;

import java.util.Stack;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 17:16
 */
public class Test {
    public static void main(String[] args) {
        try {
            Context context = new Context();
            /**
             * 定义一个容器，用于存储一个具体表达式
             * @author Mr.Longyx
             * @date 2020/7/12 17:16
             */
            Stack<Expression> stack = new Stack<> ();
//            for (;;){
//                //进行语法解析，并产生递归调用
//            }
            /**
             * 获取得到最终的解析表达式：完整语法树
             * @author Mr.Longyx
             * @date 2020/7/12 17:18
             */
            Expression expression = stack.pop();
            /**
             * 递归调用获取结果
             * @author Mr.Longyx
             * @date 2020/7/12 17:18
             */
            expression.interpret(context);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
