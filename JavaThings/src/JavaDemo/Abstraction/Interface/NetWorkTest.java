package JavaDemo.Abstraction.Interface;

public class NetWorkTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);

        proxyServer.browse();
    }
}

interface NetWork {
    public void browse();
}

//被代理类
class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("access network");
    }
}

//代理类
class ProxyServer implements NetWork {
    private NetWork netWork;

    public ProxyServer(NetWork netWork) {
        this.netWork = netWork;
    }

    public void check() {
        System.out.println("something pre");
    }

    @Override
    public void browse() {
        check();
        netWork.browse();
    }
}