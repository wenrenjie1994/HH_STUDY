package thread;

/**
 * @program: TODO
 * @className:Demo01
 * @description:TODO
 * @author: 何文艺
 * @create: 2020/7/16 16:29
 **/
public class Demo01 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
        System.out.println(Thread.currentThread().getName());
    }
}
