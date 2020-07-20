package thread;

/**
 * @program: TODO
 * @className:RunnableImpl
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/17 9:22
 **/
//1.创建一个Runnable接口的实现类
public class RunnableImpl implements Runnable {
    @Override
    //2.在实现类中重写Runnable接口的run方法，设置线程任务
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
