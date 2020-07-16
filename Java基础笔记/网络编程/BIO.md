### BIO：服务器监听、客户端请求服务器、服务器确认、开始通信。

````java
public class ServerHandler implements Runnable{
   private Socket socket ;
   public ServerHandler(Socket socket){
      this.socket = socket;
   }
   @Override
   public void run() {
      BufferedReader in = null;
      PrintWriter out = null;
      try {
         in = new BufferedReader(new InputStreamReader
             (this.socket.getInputStream()));
         out = new PrintWriter(this.socket.getOutputStream(),true);
         String body = null;
         while(true){
            body = in.readLine();
            if(body == null) break;
            System.out.println("Server :"+ body);
            out.println("服务器端回送响的应数据.");
         }     
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(in != null){
            try {
               in.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if(out != null){
            try {
               out.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if(socket != null){
            try {
               socket.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         socket = null;
      }   
   }
}
````
服务端
````java
public class Server {
   final static int PROT =8765;
   public static void main(String[] args) {
      ServerSocket server = null;
      try {
         server = new ServerSocket(PROT);
         System.out.println(" server start .. ");
         //进行阻塞
         Socket socket = server.accept();
         //新建一个线程执行客户端的任务
         newThread(new ServerHandler(socket)).start();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
            if (server !=null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
   }
````
客户端
````java 
public classClient {
   final static String ADDRESS ="127.0.0.1";
   final static int PORT =8765;
   public static void main(String[] args) {
      Socket socket = null;
      BufferedReader in = null;
      PrintWriter out = null;
      try {
         socket = new Socket(ADDRESS, PORT);
         in = new BufferedReader(newInputStreamReader(socket.getInputStream()));
         out = new PrintWriter(socket.getOutputStream(),true);
         //向服务器端发送数据
         out.println("接收到客户端的请求数据...");
         out.println("接收到客户端的请求数据1111...");
         String response = in.readLine();
         System.out.println("Client: " + response);
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if(in != null){
            try {
               in.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         if(out != null){
            try {
               out.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
         if(socket != null){
            try {
               socket.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         }
         socket = null;
      }
   }
}
````
## 改进：加入线程池，避免每次新建线程
新建线程
````java 
public class ServerHandler implements Runnable {
    private Socket socket;
    public ServerHandler (Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader
                (this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String body = null;
        while(true){
            body = in.readLine();
            if(body == null) break;
                System.out.println("Server:" + body);
                out.println("Server response");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //...关闭所有的流
        }
    }
}
````
线程池的方法
````java
public class HandlerExecutorPool {
    private ExecutorService executor;
    public HandlerExecutorPool(int maxPoolSize, int queueSize){
        //建立线程池
        this.executor = new ThreadPoolExecutor(
        Runtime.getRuntime().availableProcessors(),
        maxPoolSize,120L,TimeUnit.SECONDS,
        new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable task){
        this.executor.execute(task);
    }
}
````
服务端
````java
public class Server {
    public static void main(String[] args) {
        final static int PORT = 8765;
        ServerSocket server = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("server start");
            Socket socket = null;
            HandlerExecutorPool executorPool = 
                    new HandlerExecutorPool(50, 1000);
            while(true){
            socket = server.accept();
            executorPool.execute(new ServerHandler(socket));
            }
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
        //关闭所有的流
        }
    }
}
````
客户端
````java
public class Client {
    public static void main(String[] args) {
        final static String ADDRESS = "127.0.0.1";
        final static int PORT =8765;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket(ADDRESS, PORT);
            in = new BufferedReader(new InputStreamReader
                (socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Client request");
            String response = in.readLine();
            System.out.println("Client:" + response);
        }  catch (Exception e) {
        e.printStackTrace();
        } finally {
        //关闭所有的流
        }
    }
}
````
