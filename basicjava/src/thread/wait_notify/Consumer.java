package thread.wait_notify;

import java.util.Stack;

public class Consumer {
    public synchronized void PullChar(Stack<Character> stack){
        if (stack.size()==0){
            try {
                this.wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        System.out.println(stack.pop());
    }
}
