package multi_process;

/**
 * 多线程按照顺序执行
 * @author: chenlei
 * @date: 12:05 2020/6/12
 **/
public class InTurnMultiProcess implements Runnable{
    static int value = 0;
    @Override
    public void run() {
        while (value < 100) {
            synchronized (InTurnMultiProcess.class){
                System.out.println(Thread.currentThread().getName() + ":" + value++);
                InTurnMultiProcess.class.notify();
                try {
                    InTurnMultiProcess.class.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new InTurnMultiProcess(),"偶数线程").start();
        new Thread(new InTurnMultiProcess(),"奇数线程").start();
    }
}
