package ThreadCommunication;

/**
 * @Description 生产者/消费者问题
 * @author liuclo
 * @date 2020/8/2 22:00
 */

public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        
        Producer p1 = new Producer(clerk);
        p1.setName("生产者");
        
        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者");
        
        p1.start();
        c1.start();
    }
}

class Clerk {
    private static final int MAX_NUM = 20;
    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct() {
        if (productCount < MAX_NUM) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + "生产第" + productCount +"号产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + "消费第" + productCount + "号产品");
            productCount--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//生产者
class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：生产产品...");
        
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

//消费者
class Consumer extends Thread {
    private Clerk clerk;
    
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：消费产品...");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
