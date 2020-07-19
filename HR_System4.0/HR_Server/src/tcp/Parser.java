package tcp;

import model.OperatorResult;
import model.Resume;
import model.ReturnResult;

import java.util.LinkedList;

public class Parser {

    public ReturnResult parser(String str)
    {
        /*
         * 先按“\t”把str分开，分别得到具体操作 和具体的求职者信息
         *然后根据得到的具体操作 通过相应方法解码
         * */
        String[] arrayMessage=str.split("\t");//客户端发送过来的信息拆分
        String head=arrayMessage[0];//具体操作
        String message=arrayMessage[1];//求职者信息
        ReturnResult returnResult=new ReturnResult();
        returnResult.head=head;
        if(head.equals("添加简历"))
        {
            LinkedList<Resume> list =parserAdd(message);
            returnResult.resultData=list;
        }
        else if(head.equals("通过姓名删除简历"))
        {
            LinkedList<Resume>list=parserDeleteByName(message);
            returnResult.resultData=list;
        }
        else if(head.equals("通过身份证号码删除简历"))
        {
            LinkedList<Resume>list=parserDeleteById(message);
            returnResult.resultData=list;
        }
        else if(head.equals("通过学校删除简历"))
        {
            LinkedList<Resume>list=parserDeleteBySchool(message);
            returnResult.resultData=list;
        }
        else if(head.equals("更新简历信息"))
        {
            LinkedList<Resume>list=parserUpdate(message);
            returnResult.resultData=list;
        }
        else if(head.equals("按照姓名查询"))
        {
            LinkedList<Resume>list=parserSearchByName(message);
            returnResult.resultData=list;
        }
        else if(head.equals("按照身份证号码查询"))
        {
            LinkedList<Resume>list=parserSearchById(message);
            returnResult.resultData=list;
        }
        else if(head.equals("按照学校查询"))
        {
            LinkedList<Resume>list=parserSearchBySchool(message);
            returnResult.resultData=list;
        }
        return returnResult;

    }
    public LinkedList<Resume> parserAdd(String message){
        String[] arrayMessage =message.split(";");
        String name = arrayMessage[0];
        String id = arrayMessage[1];
        String school = arrayMessage[2];
        int process = Integer.parseInt(arrayMessage[3]);
        Resume resume =new Resume(name,id,school,process,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        return list;
    }
    public LinkedList<Resume> parserDeleteByName(String message){
        String[] arrayMessage =message.split(";");
        String name = arrayMessage[0];
        Resume resume =new Resume(name,null,null,0,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        return list;
    }
    public LinkedList<Resume> parserDeleteById(String message){
        String[] arrayMessage =message.split(";");
        String id = arrayMessage[0];
        Resume resume =new Resume(null,id,null,0,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        return list;
    }
    public LinkedList<Resume> parserDeleteBySchool(String message){
        String[] arrayMessage =message.split(";");
        String school = arrayMessage[0];
        Resume resume =new Resume(null,null,school,0,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        return list;
    }
    public LinkedList<Resume> parserUpdate(String message){
        String[] str =message.split("/");
        String[] resumeMessage =str[0].split(";");
        String[] oldResumeMessage = str[1].split(";");
        String name = resumeMessage[0];
        String id = resumeMessage[1];
        String school =resumeMessage[2];
        int process =Integer.parseInt(resumeMessage[3]);
        Resume resume =new Resume(name,id,school,process,1);
        /////
        String oldName = oldResumeMessage[0];
        String oldId = oldResumeMessage[1];
        String oldSchool =oldResumeMessage[2];
        int oldProcess =Integer.parseInt(oldResumeMessage[3]);
        Resume oldResume =new Resume(oldName,oldId,oldSchool,oldProcess,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        list.add(oldResume);
        return list;
    }
    public LinkedList<Resume> parserSearchByName(String message){
        String[] arrayMessage = message.split(";");
        String name = arrayMessage[0];
        Resume resume =new Resume(name,null,null,0,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        return list;
    }
    public LinkedList<Resume> parserSearchById(String message){
        String id = message;
        Resume resume =new Resume(null,id,null,0,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        return list;
    }
    public LinkedList<Resume> parserSearchBySchool(String message){
        String school = message;
        Resume resume =new Resume(null,null,school,0,1);
        LinkedList<Resume> list = new LinkedList<Resume>();
        list.add(resume);
        return list;
    }

}
