package qiuhaoran_q1_multithreading;

/**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 14:58 2020/5/22
 * @Modified By:
 */
//继承Thread
public class KillThread extends Thread{

    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
// 重写run方法
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}