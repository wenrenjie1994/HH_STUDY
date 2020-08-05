package Thread.NewThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 使用线程池
 * @author liuclo
 * @date 2020/8/3 10:30
 */

class NumberThread implements Runnable {
    @Override
    public void run() {
        for (int i=2; i<=100; i++) {
            if (isPrime(i)) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    public boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i=2; i<=Math.sqrt(x); i++) {
            if (x%i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1. 提供指定线程数的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //2. 执行指定的线程的操作，需要提供一个实现Runnable或Callable接口的实现类的对象
        service.execute(new NumberThread());          //适用于Runnable
//        service.submit(Callable callable);           //适用于Callable

        //3. 关闭连接池
        service.shutdown();
    }
}
