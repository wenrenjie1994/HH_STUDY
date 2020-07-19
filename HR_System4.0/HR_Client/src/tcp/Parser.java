package tcp;

import resume.Resume;

import java.util.LinkedList;

//解析
/*
* 1.先按照“\t”把messgae分开；
* 2.如果isSuccess成功，把message分开的第二个string 按照"/"分开，在按照”；“分开。
* */
public class Parser {
    public ReturnResult parserAdd(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("添加成功")){
            returnResult.isSuccess =true;
        }else{
            returnResult.failReason=parserMessage[1];
        }
        return returnResult;
    }
    public ReturnResult parserDeleteByName(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("通过姓名删除成功")){
            returnResult.isSuccess =true;
        }else{
            returnResult.failReason=parserMessage[1];
        }
        return returnResult;
    }
    public ReturnResult parserDeleteById(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("通过身份证号码删除成功")){
            returnResult.isSuccess =true;
        }else{
            returnResult.failReason=parserMessage[1];
        }
        return returnResult;
    }public ReturnResult parserDeleteBySchool(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("通过学校删除成功")){
            returnResult.isSuccess =true;
        }else{
            returnResult.failReason=parserMessage[1];
        }
        return returnResult;
    }
    public ReturnResult parserUpdate(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("更新成功")){
            returnResult.isSuccess =true;
        }else{
            returnResult.failReason=parserMessage[1];
        }
        return returnResult;
    }
    public ReturnResult parserSearchByName(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("按照姓名查询成功")){
            returnResult.isSuccess =true;
            String[] resumeInfo = parserMessage[1].split("/");
            LinkedList<Resume> list = new LinkedList<Resume>();
            int len = resumeInfo.length;
            for(int i=0;i<len;i++){
                String[] resumeMessage = resumeInfo[i].split(";");
                String name = resumeMessage[0];
                String id =resumeMessage[1];
                String school =resumeMessage[2];
                int process = Integer.parseInt(resumeMessage[3]);
                Resume resume =new Resume(name,id,school,process,1);
                list.add(resume);
            }
            returnResult.returnData=list;
        }else{
            returnResult.isSuccess=false;
            LinkedList<Resume> list =new LinkedList<Resume>();
            returnResult.failReason=parserMessage[1];
            returnResult.returnData=list;
        }
        return returnResult;
    }
    public ReturnResult parserSearchById(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("按照身份证号码查询成功")){
            returnResult.isSuccess =true;
            String[] resumeInfo = parserMessage[1].split("/");
            LinkedList<Resume> list = new LinkedList<Resume>();
            int len = resumeInfo.length;
            for(int i=0;i<len;i++){
                String[] resumeMessage = resumeInfo[i].split(";");
                String name = resumeMessage[0];
                String id =resumeMessage[1];
                String school =resumeMessage[2];
                int process = Integer.parseInt(resumeMessage[3]);
                Resume resume =new Resume(name,id,school,process,1);
                list.add(resume);
            }
            returnResult.returnData=list;
        }else{
            returnResult.isSuccess=false;
            LinkedList<Resume> list =new LinkedList<Resume>();
            returnResult.failReason=parserMessage[1];
            returnResult.returnData=list;
        }
        return returnResult;
    }
    public ReturnResult parserSearchBySchool(String message){
        ReturnResult returnResult =new ReturnResult();
        String[] parserMessage = message.split("\t");
        if(parserMessage[0].equals("按照学校查询成功")){
            returnResult.isSuccess =true;
            String[] resumeInfo = parserMessage[1].split("/");
            LinkedList<Resume> list = new LinkedList<Resume>();
            int len = resumeInfo.length;
            for(int i=0;i<len;i++){
                String[] resumeMessage = resumeInfo[i].split(";");
                String name = resumeMessage[0];
                String id =resumeMessage[1];
                String school =resumeMessage[2];
                int process = Integer.parseInt(resumeMessage[3]);
                Resume resume =new Resume(name,id,school,process,1);
                list.add(resume);
            }
            returnResult.returnData=list;
        }else{
            returnResult.isSuccess=false;
            LinkedList<Resume> list =new LinkedList<Resume>();
            returnResult.failReason=parserMessage[1];
            returnResult.returnData=list;
        }
        return returnResult;
    }
}
