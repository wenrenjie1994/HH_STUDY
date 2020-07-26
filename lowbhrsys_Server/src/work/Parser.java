package work;

import entity.ReceiveResult;
import entity.Resume;

public class Parser {
    static String[] message;
    static String head;
    static ReceiveResult rec =new ReceiveResult();
    static String data;
    public static ReceiveResult parserReceiveMsg(String str){
        message = str.split("/n");
        head = message[0];
        rec.head=head;
        data = message[1];
        if("add".equals(head)){
            rec.resultData = addResume(data);
        }
        else if ("deleteById".equals(head) || "deleteByName".equals(head) ||"findByName".equals(head) ||"findById".equals(head) ||"findByPosition".equals(head)){
            rec.resultData = data;
        }
        else if ("updataById".equals(head)){
            rec.resultData = deleteById(data);
        }
        else if ("updateByName".equals(head)){
            rec.resultData = deleteByName(data);
        }
        return  rec;
    }

    static Resume addResume(String str){
        String[] data =str.split(",");
        Resume resume = new Resume(Integer.parseInt(data[0]),data[1],data[2],data[3]);
        return resume;
    }

    static Resume deleteById(String str){
        String data[] = str.split(",");
        Resume resume = new Resume(Integer.parseInt(data[0]),data[1],data[2],data[3]);
        return resume;
    }
    static Resume deleteByName(String str){
        String data[] = str.split(",");
        Resume resume = new Resume(data[0],data[1],data[2],data[3]);
        return resume;
    }

}
