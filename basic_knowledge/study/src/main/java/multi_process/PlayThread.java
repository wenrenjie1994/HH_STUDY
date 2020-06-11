package multi_process;

/**
 * @author: chenlei
 * @date: 14:44 2020/6/11
 **/
public class PlayThread extends Thread {
    Man man;
    public PlayThread(Man man) {
        this.man = man;
    }
    public void run() {
        while (man.getTotal() < 20) {
            man.play();
        }
    }
}
