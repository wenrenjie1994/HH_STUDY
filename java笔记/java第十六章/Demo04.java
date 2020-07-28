package basic.method.demo1.day14;

public class Demo04 {
    public static void main(String[] args) {
    Demo04ThreadSafe run = new Demo04ThreadSafe();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}
