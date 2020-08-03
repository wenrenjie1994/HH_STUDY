package net;

import control.Operator;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

    BufferedReader in;
    PrintWriter out;
    Socket tcpConnection;
    Operator op = new Operator(this);
    public Client() {
        try {
            tcpConnection = new Socket("127.0.0.1", 1235);
            System.out.print("连接上服务器了\n");
            in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())), true);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String sendMessageToSever(String message)//发送字符串去客服端
    {
        String str = "";
        try {
            out.println(message);
			System.out.println("向服务器发送：  "+message);
            str = in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return str;
    }

    public void closeClient()//关闭客户端并关闭连接
    {
        try {
            in.close();
            out.close();
            tcpConnection.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Start(){
        Scanner input = new Scanner(System.in);
        //*************************主页面提示*******************************
        while(true){
            //.openData();
            System.out.println("************欢迎来到HR管理系统************");
            System.out.println("录入员工信息请按----------1");
            System.out.println("删除员工信息请按----------2");
            System.out.println("修改员工信息请按----------3");
            System.out.println("查询员工信息请按----------4");
            System.out.println("列出全部员工信息请按-------5");
            System.out.println("退出请按-----------------6");
            //if语句指令判断
            int choice =input.nextInt();
            if(choice==1){
                add();
            }
            else if(choice==2){
                deleteResume();
            }
            else if(choice==3){
                changeResume();
            }
            else if(choice==4){
                searchResume();
            }
            else if(choice==5){
                listAllResume();
            }
            else if(choice==6){
                close();
                break;
            }
            else{
                System.out.println("输入错误，请确认后重新输入");
            }
        }
        System.out.println("您已退出HR管理系统");
    }

    //*************************添加信息*******************************
    void add(){
        System.out.println("欢迎来到员工信息录入界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要录入员工的名字，身份证号，学校，申请进度");
        String workerName = input.nextLine();
        String workerId = input.nextLine();
        String workerSchool = input.nextLine();
        int preProcess = input.nextInt();
        while (preProcess > 6 || preProcess <0){
            System.out.println("申请进度只能为0-6，请重新输入：");
            preProcess = input.nextInt();
        }
        int process = preProcess;

        Resume resume = new Resume(workerName, workerId, workerSchool, process);

        ReturnResult rr = op.addResume(resume);
        CRUDResult(rr);
    }
    //*************************删除信息*******************************
    void deleteResume(){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("************欢迎来到员工信息删除界面************");
            System.out.println("按名字删除请按----------1");
            System.out.println("按id删除请按-----------2");
            System.out.println("退出请按---------------3");
            int choice =input.nextInt();
            if(choice==1){
                deleteByName();
            }
            else if(choice==2){
                deleteById();
            }
            else if(choice==3){
                break;
            }
        }

    }

    void deleteByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的员工名字");
        String workerName = input.nextLine();
        Resume resume = new Resume(workerName,null,null,-1);

        ReturnResult rr = op.deleteResumeByName(resume);
        CRUDResult(rr);
    }

    void deleteById(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的员工id");
        String workerId = input.nextLine();
        Resume resume = new Resume(null, workerId,null, -1);

        ReturnResult rr = op.deleteResumeById(resume);
        CRUDResult(rr);
    }
    //*************************修改信息*******************************
    void changeResume(){
        System.out.println("欢迎来到员工信息修改界面");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要修改员工的身份证号");
        String oldWorkerId = input.nextLine();;

        System.out.println("请依次输入修改后员工的名字，身份证号，学校，申请进度");
        String workerName = input.nextLine();
        String workerId = input.nextLine();
        String workerSchool = input.nextLine();
        int preProcess = Integer.parseInt(input.nextLine());
        while (preProcess > 6 || preProcess <0){
            System.out.println("申请进度只能为0-6，请重新输入：");
            preProcess = input.nextInt();
        }
        int process = preProcess;

        Resume oldResume = new Resume(null, oldWorkerId, null, -1);
        Resume resume = new Resume(workerName, workerId, workerSchool, process);

        ReturnResult rr = op.changeResume(resume, oldResume);
        CRUDResult(rr);
    }
    //*************************查询信息*******************************
    void searchResume(){
        while(true){
            System.out.println("************欢迎来到员工查询界面************");
            System.out.println("按姓名查找请按----------1");
            System.out.println("按id查找请按-----------2");
            System.out.println("按学校查找请按----------3");
            System.out.println("按进度查找请按----------4");
            System.out.println("模糊查找请按------------5");
            System.out.println("退出请按---------------6");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if(choice==1){
                searchResumeByName();
            }
            else if(choice==2){
                searchResumeById();
            }
            else if(choice==3){
                searchResumeBySchool();
            }
            else if(choice==4){
                searchResumeByProcess();
            }
            else if(choice==5){
                searchResumeByPointWord();
            }
            else if(choice==6){
                break;
            }
            else{
                System.out.println("请输入数字1-5");
            }
        }
    }
    void searchResumeByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的员工姓名");
        String workerName = input.nextLine();
        Resume resume = new Resume(workerName,null,null, -1);

        ReturnResult rr = op.searchByName(resume);
        searchResult(rr, "姓名", workerName);
    }

    void searchResumeById(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的员工id");
        String workerId = input.nextLine();
        Resume resume = new Resume(null, workerId,null, -1);

        ReturnResult rr = op.searchById(resume);
        searchResult(rr, "id", workerId);
    }

    void searchResumeBySchool(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的员工的学校");
        String workerSchool = input.nextLine();
        Resume resume = new Resume(null,null,workerSchool,-1);

        ReturnResult rr = op.searchBySchool(resume);
        searchResult(rr, "学校", workerSchool);
    }
    void searchResumeByProcess(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的员工的进度");
        String workerProcess= input.nextLine();
        Resume resume = new Resume(null,null,null,Integer.parseInt(workerProcess));

        ReturnResult rr = op.searchByProcess(resume);
        searchResult(rr, "进度", workerProcess);
    }

    void searchResumeByPointWord(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入关键字");
        String keyWord = input.nextLine();

        Resume resume = new Resume(keyWord,null,null,-1);
        ReturnResult rr = op.searchByKeyWord(resume);
        searchResult(rr, "关键字", keyWord);
    }
    //*************************列出所有信息*******************************
    void listAllResume(){

        ReturnResult rr = op.listAllResumeInfo();

        ResumeList resumeList = (ResumeList)rr.resultData;
        int resumeCount = resumeList.size();
        if(resumeCount>0){
            for(int i=0;i<resumeCount;i++)
                System.out.println("姓名："+resumeList.get(i).getName()+"  "
                        +"id:"+"："+resumeList.get(i).getId()+"  "
                        +"学校"+"："+resumeList.get(i).getSchool()+"  "
                        +"进度"+"："+resumeList.get(i).getProcess());
        }
        else {
            System.out.println("数据库中无员工信息");
        }
    }

    void close(){

        op.closeNet("bye");
    }
    //*************************列出所有信息*******************************
    void CRUDResult(ReturnResult result){
        if(result.isSuccess){
            System.out.println("操作成功");
        }
        else{
            System.out.println("操作失败"+"/n"+result.failReason);
        }
    }
    void searchResult(ReturnResult result, String kind, String word){
        ResumeList resumeList = (ResumeList)result.resultData;
        int resumeCount = resumeList.size();
        if(resumeCount>0){
            for(int i=0;i<resumeCount;i++)
                System.out.println("姓名："+resumeList.get(i).getName()+"  "
                        +"id:"+"："+resumeList.get(i).getId()+"  "
                        +"学校"+"："+resumeList.get(i).getSchool()+"  "
                        +"进度"+"："+resumeList.get(i).getProcess());
        }
        else {
            System.out.println("没有找到"+kind+"为"+word+"的员工");
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {

        Client c = new Client();
        c.Start();
    }

}
