package basic.method.demo1.day14;

public class Demo02Thread {
    public static void main(String[] args) {
        Runnable run = new Runnable();
        Thread t = new Thread(run);//创建Thread类对象，构造方法中传递Runnable接口的实现类对象
        t.start();
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}