package MulitiThread;

/**
 * @Description 三哥窗口售票，总票数100
 * @author liuchlo
 * @date 2020/7/31 22:00
 */
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("售票窗-1");
        window2.setName("售票窗-2");
        window3.setName("售票窗-3");

        window1.start();
        window2.start();
        window3.start();
        
        try {
            window1.join();
            window2.join();
            window3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(window1.getTotal());
        System.out.println(window2.getTotal());
        System.out.println(window3.getTotal());
    }
}

class Window extends Thread {
    private static int tickets = 100;

    private int total = 0;

    public int getTotal() {
        return total;
    }

    @Override
    public void run() {
        while (true) {
            if (tickets > 0) {
                System.out.println(getName() + ": 卖出第" + tickets + "号");
                tickets--;
                total++;
            } else {
                break;
            }
        }
    }
}
