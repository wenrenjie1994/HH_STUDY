package multi_process;

/**
 * @author: chenlei
 * @date: 15:33 2020/6/11
 **/
public class PlayThread1 implements Runnable {
    Man man;
    public PlayThread1(Man man) {
        this.man = man;
    }
    public void run() {
        while (man.getTotal() < 20) {
            man.play();
        }
    }
}
