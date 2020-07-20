package Handler;

import bean.Resume;
import dto.ReqDTO;
import service.Service;
import tool.DBConnection;
import tool.ParserAndProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by guyaren
 */
public class HrHandler implements Runnable{
    private Socket socket;
    BufferedReader in = null;
    PrintWriter out = null;
    Connection conn = DBConnection.getConnection();
    Service service = new Service();

    public HrHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(),true);
            String body = null;

            out.println("服务器连接成功");
            body = in.readLine();
            if(body!=null){
                System.out.println("Client Send :" + body);
                ReqDTO reqDTO = ParserAndProtocol.reqParser(body);
                String result = task(reqDTO);
                out.println(result);
            }
            in.close();
            out.close();
            conn.close();
            socket.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
    public String task(ReqDTO reqDTO) {
        String resStr = null;
        int line = 0;
        List<Resume> resumes = null;
        if(reqDTO.getIndexOne()==1){//add
            line = service.addResume(conn,reqDTO.getDataObj());
            resStr = ParserAndProtocol.protocolStr(line,reqDTO.getDataObj().size()-line);
        }
        else if(reqDTO.getIndexOne()==2){//delete
            String subSql = reqDTO.getDataStr().get(0);
            switch (reqDTO.getIndexTwo()){
                case 1:
                    line = service.deleteResumeByID(conn,reqDTO.getDataStr());break;
                case 2:
                    line = service.deleteResume(conn,"name='"+subSql+"'");break;
                case 3:
                    line = service.deleteResume(conn,"school='"+subSql+"'");break;
                case 4:
                    line = service.deleteResume(conn,"process="+Integer.parseInt(subSql));break;
            }
            resStr = ParserAndProtocol.protocolStr(line,reqDTO.getDataStr().size()-line);
        }
        else if(reqDTO.getIndexOne()==3){//update
            line = service.updateResume(conn,reqDTO.getDataObj());
            resStr = ParserAndProtocol.protocolStr(line,reqDTO.getDataObj().size()-line);
        }
        else{//search,
            //TODO 仅支持单一条件查询
            String subSql = reqDTO.getDataStr().get(0);
            switch (reqDTO.getIndexTwo()){
                case 1:
                    resumes=service.searchResumeByID(conn,reqDTO.getDataStr());break;
                case 2:
                    resumes=service.searchResume(conn,"name='"+subSql+"'");break;
                case 3:
                    resumes=service.searchResume(conn,"school='"+subSql+"'");break;
                case 4:
                    resumes=service.searchResume(conn,"process="+Integer.parseInt(subSql));break;
                case 5:
                    resumes=service.searchResume(conn,"deleteStatus="+Integer.parseInt(subSql));break;
                default:
                    System.out.println("二级指令错误，重新输入");
            }
            resStr = ParserAndProtocol.protocolStr(resumes);
        }

        return resStr;

    }

}
