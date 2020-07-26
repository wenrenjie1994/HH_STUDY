package thread;

import dao.ResumeDao;
import entity.ReceiveResult;
import entity.Resume;
import entity.ReturnResult;
import work.Parser;
import work.Protocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerThread extends Thread{
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    String str;
    public ServerThread(Socket socket){

        this.socket=socket;
    }

    @Override
    public void run() {

        while(true){
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

                str = in.readLine();
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if("bye".equals(str)){
                try {
                    out.print("bye");
                    out.close();
                    in.close();
                    socket.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                ReturnResult rr = new ReturnResult();
                ReceiveResult rec = Parser.parserReceiveMsg(str);
                HashMap<String,String>map = new HashMap<>();
                if("add".equals(rec.head)){
                    rr=ResumeDao.addResume((Resume) rec.resultData);
                    String message=Protocol.addResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if ("deleteById".equals(rec.head)){
                    map.put("id", (String) rec.resultData);
                    rr=ResumeDao.deleteByCondition(map);
                    map.clear();
                    String message=Protocol.deleteResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if ("deleteByName".equals(rec.head)){
                    map.put("name", (String) rec.resultData);
                    rr=ResumeDao.deleteByCondition(map);
                    map.clear();
                    String message=Protocol.deleteResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if ("updateById".equals(rec.head)){
                    map.put("id", String.valueOf(((Resume)rec.resultData).getId()));
                    Resume resume = (Resume) rec.resultData;
                    rr=ResumeDao.updateByCondition(map,resume);
                    map.clear();
                    String message=Protocol.updateResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if ("updateByName".equals(rec.head)){
                    map.put("name", ((Resume)rec.resultData).getOldName());
                    Resume resume = (Resume) rec.resultData;
                    rr=ResumeDao.updateByCondition(map,resume);
                    map.clear();
                    String message=Protocol.updateResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if ("findByName".equals(rec.head)){
                    map.put("name", (String) rec.resultData);
                    rr=ResumeDao.searchByCondition(map);
                    map.clear();
                    String message=Protocol.findResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if ("findById".equals(rec.head)){
                    map.put("id", (String) rec.resultData);
                    rr=ResumeDao.searchByCondition(map);
                    map.clear();
                    String message=Protocol.findResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if ("findByPosition".equals(rec.head)){
                    map.put("position", (String) rec.resultData);
                    rr=ResumeDao.searchByCondition(map);
                    map.clear();
                    String message=Protocol.findResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else if("searchAll".equals(rec.head)){
                    rr=ResumeDao.searchAll();
                    String message=Protocol.findResumeMessage(rr);
                    System.out.println("向客户端返回：   "+message);
                    out.println(message);

                }
                else{
                    System.out.println("客户端输入错误  ");
                    out.println("输入错误");

                }

            }
        }
        System.out.println("该客户端已退出"+socket.getInetAddress());
    }
}
