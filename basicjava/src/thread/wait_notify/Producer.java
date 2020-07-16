package thread.wait_notify;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Producer extends Thread{
    //生成随机大写字母
    public static Character ProduceChar(){
        String pool = "";
        Random r = new Random();
        for (short i='A'; i<='Z'; i++){
            pool += (char)i;
        }
        return pool.charAt(r.nextInt(pool.length()));
    }

    public synchronized void PushChar(Stack<Character> stack){
        if (stack.size()==200){
            try {
                this.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        stack.push(ProduceChar());
    }
}
