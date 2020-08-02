package lambda;

/**
 * @program: TODO
 * @className:RunnableImpl
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/24 9:26
 **/
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "新线程执行了");
    }
}
