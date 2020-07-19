package tcp;

import model.OperatorResult;
import model.Resume;

import java.util.LinkedList;

public class Protocol {
    public String addResumeMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("添加成功")){
            str=isSuccess+"\t";
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }
    public String deleteResumeByNameMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("通过姓名删除成功")){
            str=isSuccess+"\t";
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }
    public String deleteResumeByIdMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("通过身份证号码删除成功")){
            str=isSuccess+"\t";
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }
    public String deleteResumeBySchoolMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("通过学校删除成功")){
            str=isSuccess+"\t";
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }
    public String updateResumeMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("更新成功")){
            str=isSuccess+"\t";
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }
    public String searchResumeByNameMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("按照姓名查询成功")){
            str=isSuccess+"\t";
            LinkedList<Resume>list = (LinkedList<Resume>)operatorResult.returnData;
            for(int i=0;i<list.size();i++){
                String s = list.get(i).getName()+";"+list.get(i).getId()+";"+list.get(i).getSchool()+
                        ";"+list.get(i).getProcess()+";"+list.get(i).getDeleteStatus()+"/";
                str =str+s;
            }
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }
    public String searchResumeByIdMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("按照身份证号码查询成功")){
            str=isSuccess+"\t";
            LinkedList<Resume>list = (LinkedList<Resume>)operatorResult.returnData;
            for(int i=0;i<list.size();i++){
                String s = list.get(i).getName()+";"+list.get(i).getId()+";"+list.get(i).getSchool()+
                        ";"+list.get(i).getProcess()+";"+list.get(i).getDeleteStatus()+"/";
                str =str+s;
            }
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }
    public String searchResumeBySchoolMessage(OperatorResult operatorResult){
        String str;
        String isSuccess=operatorResult.isSuccess;
        if(isSuccess.equals("按照学校查询成功")){
            str=isSuccess+"\t";
            LinkedList<Resume>list = (LinkedList<Resume>)operatorResult.returnData;
            for(int i=0;i<list.size();i++){
                String s = list.get(i).getName()+";"+list.get(i).getId()+";"+list.get(i).getSchool()+
                        ";"+list.get(i).getProcess()+";"+list.get(i).getDeleteStatus()+"/";
                str =str+s;
            }
        }else{
            str =isSuccess+"\t"+operatorResult.failReason;
        }
        return str;
    }

}
