package thread;

/**
 * @program: TODO
 * @className:Demo02
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/17 9:22
 **/
public class Demo02{
    public static void main(String[] args) {
        //3.创建一个Runnable接口的实现类对象
        RunnableImpl runnable = new RunnableImpl();
        //4.创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        Thread thread = new Thread(runnable);
        //5.调用Thread类中的start方法，开启新的线程，执行run方法
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}
