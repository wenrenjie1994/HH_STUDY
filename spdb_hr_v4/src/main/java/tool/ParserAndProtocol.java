package tool;

import bean.Resume;
import dto.ReqDTO;
import dto.ResDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guyaren
 */
public class ParserAndProtocol {
    /**
     * 1&1&d1_d2_d3
     * d:,,,,
     * @param string
     * @return
     */
    public static ReqDTO reqParser(String string){
        ReqDTO reqDTO = new ReqDTO();
        String[] tmp = string.split("&");
        reqDTO.setIndexOne(Integer.parseInt(tmp[0]));
        reqDTO.setIndexTwo(Integer.parseInt(tmp[1]));
        String[] tmp2 = tmp[2].split("_");
        if(reqDTO.getIndexOne()==1 || reqDTO.getIndexOne()==3){
            reqDTO.setDataObj(parseObject(tmp2));
        }else{
            reqDTO.setDataStr(parseStr(tmp2));
        }
        System.out.println(reqDTO.toString());
        return reqDTO;
    }
    public static List<Resume> parseObject(String[] d){
        List<Resume> list = new ArrayList<>();
        for(int i=0;i<d.length;i++){
            String[] tmp = d[i].split(",");
            Resume resume = new Resume(tmp[0],tmp[1],tmp[2]);
            list.add(resume);
        }
        return list;
    }

    public static List<String> parseStr(String[] d){
        List<String> list = new ArrayList<>();
        for(int i=0;i<d.length;i++){
            String tmp = d[i];
            list.add(tmp);
        }
        return list;
    }

    public static String protocolStr(int success,int wrong){
        ResDTO resDTO = new ResDTO();
        if(success==0)
            resDTO.setCode(0);
        else if(success<wrong)
            resDTO.setCode(1);
        else
            resDTO.setCode(2);

        resDTO.setSuccess(success);
        resDTO.setWrong(wrong);

        return resDTO.toString();
    }
    public static String protocolStr(List<Resume> list){
        ResDTO resDTO = new ResDTO();
        resDTO.setCode(2);
        resDTO.setSuccess(list.size());
        System.out.println(list);
        String str = "";
        for(int i=0;i<list.size();i++){
            str += list.get(i).toString()+";";
        }
        resDTO.setData(str);
        return resDTO.toString();
    }
}
