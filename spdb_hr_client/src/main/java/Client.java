import handler.Thread1;
import handler.Thread2;
import handler.Thread3;
import handler.Thread4;
import java.io.IOException;


/**
 * Created by guyaren
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread3();
        Thread t4 = new Thread4();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
