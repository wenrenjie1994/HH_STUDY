import service.ClientService;

/**
 * @Author: chenlei
 * @Date: 2020/7/17 15:43
 */
public class ClientMain {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        clientService.run();
    }
}
