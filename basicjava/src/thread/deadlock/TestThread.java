package thread.deadlock;

//3个同步对象a, b, c
//        3个线程 t1,t2,t3
//
//        故意设计场景，使这3个线程彼此死锁

public class TestThread {
    public static void main(String[] args) {
        Hero a = new Hero();
        a.name = "a";

        Hero b = new Hero();
        b.name = "b";

        Hero c = new Hero();
        c.name = "c";

        Thread t1 = new Thread() {
            public void run() {
                synchronized (a) {
                    System.out.println("t1 占有对象a");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t1 试图占有b");
                    System.out.println("t1 等待中 。。。。");
                    synchronized (b) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                synchronized (b) {
                    System.out.println("t2 占有对象b");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t2 试图占有c");
                    System.out.println("t2 等待中 。。。。");
                    synchronized (c) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t2.start();

        Thread t3 = new Thread() {
            public void run() {
                synchronized (c) {
                    System.out.println("t3 占有对象c");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("t3 试图占有a");
                    System.out.println("t3 等待中 。。。。");
                    synchronized (a) {
                        System.out.println("do something");
                    }
                }
            }
        };
        t3.start();
    }
}
