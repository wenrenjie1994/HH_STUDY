package Thread.ThreadSecurity;

public class Window {
    public static void main(String[] args) {
        Sell s = new Sell();

        Thread thread1 = new Thread(s);
        Thread thread2 = new Thread(s);
        Thread thread3 = new Thread(s);

        thread1.setName("窗口-1");
        thread2.setName("窗口-2");
        thread3.setName("窗口-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Sell implements Runnable {
    private int ticket = 100;

    public static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notifyAll();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + ticket);
                    ticket--;
                } else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
