package multithreading;

/**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 15:07 2020/5/22
 * @Modified By:
 */
//实现Runnable接口
public class Battle implements Runnable{

    private Hero h1;
    private Hero h2;

    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
