import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockDemo {

    public static String now() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg) {
        System.out.printf("%s %s %s %n", now() , Thread.currentThread().getName() , msg);
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread() {
            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    lock.lock();

                    log("占有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象：lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try {
            //先让t1飞2秒
            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Thread t2 = new Thread() {

            public void run() {
                try {
                    log("线程启动");
                    log("试图占有对象：lock");

                    lock.lock();

                    log("占有对象：lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    log("释放对象：lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t2.setName("t2");
        t2.start();
    }

}