package basic.method.demo1.day14;

public class Mythread extends Thread {
    @Override
    public void run() {
   /*     for (int i = 0; i < 10; i++) {
            System.out.println("run"+i);
        }
        String name = getName();
        System.out.println(name);*/
//   Thread t = Thread.currentThread();
        System.out.println(Thread.currentThread().getName());

    }
}
