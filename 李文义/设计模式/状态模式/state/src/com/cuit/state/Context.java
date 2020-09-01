package com.cuit.state;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class Context {
    /**
     * 功能描述:
     * 定义出所有的电梯状态
     *
     * @author: liwenyi
     */
    public final static OpenningState openningState = new OpenningState();
    public final static ClosingState closeingState = new ClosingState();
    public final static RunningState runningState = new RunningState();
    public final static StoppingState stoppingState = new StoppingState();
    /**
     * 功能描述:
     * 定义一个当前电梯状态
     *
     * @author: liwenyi
     */
    private LiftState liftState;
    public LiftState getLiftState() {
        return liftState;
    }
    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        this.liftState.setContext(this);
    }
    public void open(){
        this.liftState.open();
    }
    public void close(){
        this.liftState.close();
    }
    public void run(){
        this.liftState.run();
    }
    public void stop(){
        this.liftState.stop();
    }
}
