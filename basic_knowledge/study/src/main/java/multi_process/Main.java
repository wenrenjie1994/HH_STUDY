package multi_process;

/**
 * @author: chenlei
 * @date: 14:27 2020/6/11
 **/
public class Main {
    public static void main(String[] args) {
        Man blue = new Man("blue",0);
        Man red = new Man("red",0);
        Man green = new Man("green",0);
        //thread
//        PlayThread blueThread = new PlayThread(blue);
//        PlayThread redThread = new PlayThread(red);
//        PlayThread greenThread = new PlayThread(green);
        //runnable
//        PlayThread1 blueThread = new PlayThread1(blue);
//        PlayThread1 redThread = new PlayThread1(red);
//        PlayThread1 greenThread = new PlayThread1(green);
//        new Thread(blueThread).start();
//        new Thread(redThread).start();
//        new Thread(greenThread).start();
        //匿名内部类
        Thread blueThread = new Thread(){
            public void run() {
                while (blue.getTotal() < 20) {
                    blue.play();
                }
            }
        };
        Thread redThread = new Thread(){
            public void run() {
                while (red.getTotal() < 20) {
                    red.play();
                }
            }
        };
        Thread greenThread = new Thread(){
            public void run() {
                while (green.getTotal() < 20) {
                    green.play();
                }
            }
        };
        blueThread.start();
        redThread.start();
        greenThread.start();
    }

}
