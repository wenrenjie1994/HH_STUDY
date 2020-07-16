import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSocket {
//    public static void main(String[] args) throws UnknownHostException {
//        //获取本机ip地址
//        InetAddress host = InetAddress.getLocalHost();
//        String ip = host.getHostAddress();
//        System.out.println("本机ip地址：" + ip);
//
//    }

    public static void main(String[] args) throws IOException {
        //使用java执行ping命令
        Process process = Runtime.getRuntime().exec("ping " + "192.168.0.106");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            if (line.length() != 0) {
                stringBuilder.append(line + "\r\n");
            }
        }
        System.out.println("本次指令返回的消息是:");
        System.out.println(stringBuilder.toString());
    }
}
