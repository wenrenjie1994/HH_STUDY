package com.cuit.state;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class RunningState extends LiftState {
    @Override
    public void open() {
        //do nothing
    }

    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void run() {
        System.out.println("电梯上下运行...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);//环境设置为停止状态
        super.context.getLiftState().stop();
    }
}
