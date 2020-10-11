package com.longyx.study.design.pattern.interpreter.general;

/**
 * 抽象表达式
 * 解释器模式适用场景：
 * 1、一些重复出现的问题可以用一种简单的语言来进行表达
 * 2、一个简单语法需要解释的场景
 * 解释器模式：
 * 优点：
 * 1、扩展性强：在解释器模式中由于语法是由很多类表示的，当语法规则更改时，只需修改相应的非终结符表达式即可；若扩展语法时，只需添加相应非终结符类即可
 * 2、增加了新的解释表达式的方式
 * 3、易于实现文法：解释器模式对应的文法应当是比较简单且易于实现的，过于复杂的语法并不适合使用解释器模式
 * 缺点：
 * 1、语法规则较复杂时，会引起类膨胀
 * 2、执行效率比较低(递归处理的的情况)
 * @author Mr.Longyx
 * @date 2020年07月12日 17:10
 */
public interface Expression {
    /**
     * 对表达式进行解释
     * @author Mr.Longyx
     * @date 2020/7/12 17:10
     */
    Object interpret(Context context);
}
