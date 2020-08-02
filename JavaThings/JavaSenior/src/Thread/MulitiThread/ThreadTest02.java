package Thread.MulitiThread;

/**
 * @Description 创建多线程方式二：实现Runnable接口
 *      创建一个实现Runnable接口的类
 *      实现类去实现Runnable接口中的抽象方法run()
 *      创建实现类的对象
 *      将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *      通过Thread类的对象去调用start()方法
 * @author liuclo
 * @date 2020/8/1 9:50
 */

public class ThreadTest02 {
    public static void main(String[] args) {
        //创建实现类的对象
        MyThread myThread1 = new MyThread();

        //将对象作为参数传递到Tread类的构造器中，创建Thread对象
        Thread thread1 = new Thread(myThread1);

        //调用start()
        thread1.start();

        Thread thread2 = new Thread(myThread1);
        thread2.start();
    }
}

//创建一个实现了Runnable接口的类
class MyThread implements Runnable {
    //实现类重写run()方法
    @Override
    public void run() {
        for (int i=0; i<=100; i++) {
            if (i%2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
