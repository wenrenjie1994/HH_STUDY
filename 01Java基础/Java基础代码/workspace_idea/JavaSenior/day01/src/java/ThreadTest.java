package java;

/**
 * 创建多线程的方式二：
 *
 * @author zhaopan@163.com
 * @creat 2020-04-15 13:24
 */

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        t1.setName("线程一");
        t1.start();

        //再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(myThread);
        t2.setName("线程二");
        t2.start();


    }


}
