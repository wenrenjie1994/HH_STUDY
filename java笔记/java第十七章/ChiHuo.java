package basic.method.demo1.day15;

public class ChiHuo extends Thread{
    /*
    吃货类：是一个线程类，可以继承Thread
    设置线程任务（run）：吃包子
    对包子的状态进行判断
    false：没有包子，吃货调用wait方法进入等待状态
    ture:有包子，吃货吃包子，吃完包子，修改包子的状态为false
    吃货唤醒包子铺线程，生产包子
     */
    private Baozi bz;

    public ChiHuo(Baozi bz){
        this.bz = bz;
    }

    @Override
    public void run() {
        synchronized (bz){
            if (bz.flag ==false){
                try {
                    bz.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("吃货正在吃："+bz.pi+bz.xian+"的包子");
            bz.flag = false;
            bz.notify();
        }
    }
}
