package basic.method.demo1.day14;

public class Demo04ThreadSafe implements java.lang.Runnable {
    private int tickets = 10;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //     synchronized (obj){
            /*if (tickets>=0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets + "张票");
                tickets--;*/
            // }
            payTickets();
        }
    }

    public synchronized void payTickets() {
        if (tickets >= 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在卖第" + tickets + "张票");
            tickets--;
        }
    }
}
