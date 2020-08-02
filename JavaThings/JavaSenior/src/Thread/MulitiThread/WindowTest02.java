package Thread.MulitiThread;

public class WindowTest02 {
    public static void main(String[] args) {
        //创建实现类的对象
        Window02 window = new Window02();

        //将实现类的对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        //重命名线程
        t1.setName("窗口-1");
        t2.setName("窗口-2");
        t3.setName("窗口-3");

        //启动线程，自动调用run()方法
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println(window.getTotal());
    }
}

//创建实现Runnable接口的类
class Window02 implements Runnable {
    //只有一个Window2对象，可不用static
    private int ticket = 100;

    private int total = 0;

    public int getTotal() {
        return total;
    }

    //重写run()方法
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "出票第" + ticket + "号");
                ticket--;
                total++;
            } else {
                break;
            }
        }
    }
}
