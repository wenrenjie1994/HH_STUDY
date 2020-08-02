package Thread.Lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 解决线程安全问题 方式三：Lock锁
 * @author liuclo
 * @date 2020.8.2 16:27
 */

public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();

        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口-1");
        t2.setName("窗口-2");
        t3.setName("窗口-3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    private int ticket = 100;

    //1.实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2.调用lock()方法
                lock.lock();

                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：所售票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.解锁
                lock.unlock();
            }
        }
    }
}
