package com.spdb.study.design.pattern.command.general;

/**
 *抽象命令接口
 * 命令模式适用场景：
 *1、现实语义中具备“命令”的操作（如命令菜单，shell命令等）
 * 2、请求调用者和请求接收者需要解耦，使得调用者和接收者不直接交互
 * 3、需要抽象出等待执行的行为，比如撤销(Undo)操作和恢复(Redo)等操作
 * 4、需要支持命令宏(即命令组合操作)
 * 优点：
 * 1、通过引入中间件(抽象接口),解耦了命令请求与实现
 * 2、扩展性良好，可以很容易得增加新命令
 * 3、支持组合命令，支持命令队列
 * 4、可以在现有命令的基础上，增加额外功能(比如日志记录)
 * 缺点：
 * 1、具体命令类可能过多
 * 2、增加了程序的复杂度，理解更加困难
 * @author Mr.Longyx
 * @date 2020年07月11日 14:32
 */
public interface Command {
    void execute();
}