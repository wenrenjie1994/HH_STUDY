package work;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 16:09
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClientThread extends Thread{
    private InputStream in;
    public ClientThread(InputStream in)
    {
        //获取客户端的写操作流in
        this.in=in;
    }
    public void run()
    {
        while(true)
        {

            try {
                BufferedReader brd=new BufferedReader(new InputStreamReader(in));
                String s = brd.readLine();
                System.out.println(s);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
