
import bean.Resume;
import bean.ResumeList;
import sys.HRS;
import sys.HRSService;

import java.net.* ;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.* ;

public class SocketService {
    private ExecutorService pool=null;

    public static void main(String[] args) {
        int port = 8888;
        SocketService server = new SocketService();
        server.serverTest(port);
    }

    private class InnerThread implements Runnable{
        private Socket clientSocket = null;

        public InnerThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            //accept connection and communicate
            String buf = null;
            BufferedReader br = null;
            PrintWriter pw = null;
            String name = null;
            String idcard = null;
            String school = null;

            try {
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("ready");

                //read
                while(true){
                    buf = br.readLine();
                    String[] split = buf.split(" ");
                    //获取操作码，看采取哪种方式
                    int operate = Integer.parseInt(split[0]);
                    switch (operate){
                        case 1:
                            name = split[1];
                            idcard = split[2];
                            school = split[3];
                            Resume newResume = new Resume(name,idcard,school);
                            int result1 = HRS.addResume(newResume);
                            //通过socket将结果反馈给客户端
                            if (result1>0){
                                pw.println("添加成功");
                                pw.flush();
                            }else {
                                pw.println("添加失败");
                                pw.flush();
                            }
                            break;
                        case 2:
                            idcard = split[1];
                            int result2 = HRS.deleteResume(idcard);
                            //通过socket将结果反馈给客户端
                            if (result2>0){
                                pw.println("删除成功");
                                pw.flush();
                            }else {
                                pw.println("删除失败");
                                pw.flush();
                            }
                            break;
                        case 3:
                            idcard = split[1];
                            ResumeList resumeList = HRS.updateResume(idcard);
                            if (resumeList.size() == 0){
                                pw.println("没有该用户");
                                pw.flush();
                                break;
                            }
                            pw.println("输入修改内容");
                            pw.flush();

                            buf = br.readLine();
                            split = buf.split(" ");
                            Resume resume = new Resume(split[0],split[1],split[2]);
                            HRSService hrsService = new HRSService();
                            int result = hrsService.updataResuem(resume,idcard);
                            //通过socket将结果反馈给客户端
                            if (result >0){
                                pw.println("修改成功");
                                pw.flush();
                            }else {
                                pw.println("修改失败");
                                pw.flush();
                            }
                            break;
                        case 4:
                            int choose = Integer.parseInt(split[1]);
                            ResumeList resumes = HRS.selectResume(choose, split[2]);
                            if (resumes.size() == 0){
                                pw.println("没有该用户");
                                pw.flush();
                            }else {
                                String res = "----------查询结果---------" + "\n";
                                Iterator it = resumes.iterator();
                                while (it.hasNext()){
                                    Resume resume1 = (Resume) it.next();
                                    res += (" 姓名："+resume1.getName()+" 身份证："+resume1.getId()
                                            +" 学校："+resume1.getSchool() + "\n");

                                }
                                res += "-------------------" + "\n";
                                pw.println(res);
                                pw.flush();
                            }

                    }


                    if(buf.equals("close")){
                        break;
                    }


                }

                //close
                System.out.println("close client");
                br.close();
                pw.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void serverTest (int port) {
        ServerSocket serverSocket = null;
        pool = Executors.newFixedThreadPool(2);

        try{
            //bind and listen port
            serverSocket = new ServerSocket(port);
            System.out.println("bind port: " + port);

            while(true){

                //accept
                Socket clientSocket = null;
                //System.out.println("waiting connection...");
                clientSocket = serverSocket.accept();

                InnerThread innerThread = new InnerThread(clientSocket);
                pool.execute(innerThread);

            }

        }catch(Exception e){
            e.printStackTrace();
            pool.shutdown();
        }

    }



}