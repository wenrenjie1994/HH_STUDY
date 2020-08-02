package Thread.MulitiThread;

/**
 * @Description 多线程的创建：1. 继承与Thread类
 *      创建一个继承Thread的子类
 *      重写run()，将此线程执行的操作声明在其中
 *      创建对象
 *      调用start()
 * @author
 * @date 2020/7/31 15:10
 */
public class ThreadTest01 {
    public static void main(String[] args) {
        //创建子类对象
        EvenNum evenNum = new EvenNum();
        OddNum oddNum = new OddNum();

        //调用start()
        evenNum.start();
        oddNum.start();

        //创建Thread类的匿名子类
        new Thread() {
            @Override
            public void run() {
                for (int i=2; i<100; i++) {
                    if (isPrime(i)) {
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }

            public boolean isPrime(int x) {
                for (int i=2; i<=Math.sqrt(x); i++) {
                    if (x%2 == 0) {
                        return false;
                    }
                }
                return true;
            }
        }.start();

        /*
        for (int i=0; i<100; i++) {
            if (i%2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
         */

    }
}

//继承Thread类
class EvenNum extends Thread {

    //重写run()方法
    @Override
    public void run() {
        for (int i=0; i<50; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " +  i);
            }
        }
    }
}

class OddNum extends Thread {
    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class Prime extends Thread {
    @Override
    public void run() {
        for (int i=2; i<100; i++) {
            if (isPrime(i)) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    public boolean isPrime(int x) {
        for (int i=2; i<=Math.sqrt(x); i++) {
            if (x%2 == 0) {
                return false;
            }
        }
        return true;
    }
}
