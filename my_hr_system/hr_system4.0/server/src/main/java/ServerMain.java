import service.ServerService;

/**
 * @Author: chenlei
 * @Date: 2020/7/17 15:43
 */
public class ServerMain {
    public static void main(String[] args) {
        if(args.length == 2) {
            int port = Integer.parseInt(args[1]);
            ServerService serverService = new ServerService();
            serverService.run(port);
        }else{
            System.out.println("请在设置程序运行参数");
        }
    }
}
