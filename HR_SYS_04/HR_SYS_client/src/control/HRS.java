package control;

import bean.Resume;
import bean.ResumeList;
import bean.ReturnResult;
import net.Client;
import utils.Parser;
import utils.Protocol;

import java.util.Iterator;
import java.util.Scanner;

public class HRS {


    Client client=Client.getClient();


    //添加简历
    public void addResume() {

        System.out.println("欢迎进入添加简历界面");
        System.out.println("请依次输入简历需要添加的姓名，身份证，学校");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String idcard = scanner.nextLine();
        String school = scanner.nextLine();
        Resume newResume = new Resume(name,idcard,school);

        Protocol protocol = new Protocol();
        String message = protocol.AddResumeMessage(newResume);
        String returnMessage = client.sendMessageToSever(message);

        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserAdd(returnMessage);

        //HRSService hrsService = new HRSService();
        //int result = hrsService.addResume(newResume);
        if (returnResult.isSuccess){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
        //resumeList.add(newResume);
        //DataOperate.saveData(resumeList);

    }
    //删除简历
    public void deleteResume() {

        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除简历的身份证");
        Scanner scanner=new Scanner(System.in);
        String id = scanner.nextLine();

        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeMessage(id);
        String returnMessage = client.sendMessageToSever(message);

        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserDelete(returnMessage);
        if (returnResult.isSuccess){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
//
//        HRSService hrsService = new HRSService();
//        int result = hrsService.deleteResuem(id);
//
//        if (result >0){
//            System.out.println("删除成功");
//        }else {
//            System.out.println("删除失败");
//        }

    }
    //修改简历
    public void updateResume() {
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改简历的身份证");
        Scanner scanner=new Scanner(System.in);
        String id = scanner.nextLine();


        Protocol protocol = new Protocol();
        String message = protocol.selectResumeByIdMessage(id);
        String returnMessage = client.sendMessageToSever(message);

        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        ResumeList resumeList = (ResumeList) returnResult.resultData;
        if (resumeList.size() == 0){
            System.out.println("没有该用户");
            return;
        }
        //HRSService hrsService = new HRSService();
        System.out.println("输入修改内容");
        Resume resume = new Resume(scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
//        resume.setName(scanner.nextLine());
//        resume.setId(scanner.nextLine());
//        resume.setSchool(scanner.nextLine());

        String message1 = protocol.updateResumeMessage(resume, id);
        String returnMessage1 = client.sendMessageToSever(message1);
        ReturnResult returnResult1 = parser.parserChange(returnMessage1);
        if (returnResult.isSuccess){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }


    }
    //查询简历
    public void selectResume() {
        while(true) {
            System.out.println("欢迎进入查询简历界面");

            System.out.println("身份证查询请按------1");
            System.out.println("姓名查询请按------2");
            System.out.println("学校查询请按------3");
            System.out.println("查询全部请按------4");
            System.out.println(" 退  出 请按------5");
            Scanner scanner=new Scanner(System.in);
            int choose = scanner.nextInt();
            if (choose==1){
                selectResumeById();
            }else if (choose==2){
                selectResumeByName();
            }else if (choose==3){
                selectResumeBySchool();
            }else if(choose==4){
                selectAllResume();
            }else if (choose==5){
                return;
            }else {
                System.out.println("输入错误");
            }
//            String id = scanner.nextLine();
//        Iterator it = resumeList.iterator();
//        boolean flag = true;
//        while (it.hasNext()){
//
//            Resume resume = (Resume) it.next();
//
//            if (id.equals(resume.getId())){
//                flag = false;
//                System.out.println("查询结果");
//                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
//                        +" 学校："+resume.getSchool());
//                break;
//            }
        }
//        if (flag == true){
//            System.out.println("没有该应聘者");
//        }
        //DataOperate.saveData(resumeList);
    }

    private void selectResumeBySchool() {
        System.out.println("请输入学校名称");
        Scanner scanner=new Scanner(System.in);
        String School = scanner.nextLine();
        Protocol protocol = new Protocol();
        String message = protocol.selectResumeBySchoolMessage(School);
        String returnMessage = client.sendMessageToSever(message);

        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        ResumeList resumeList = (ResumeList) returnResult.resultData;
        if (returnResult.isSuccess){
            System.out.println("查询成功");
            Iterator it = resumeList.iterator();
            System.out.println("----------查询结果---------");
            while (it.hasNext()){

                Resume resume = (Resume) it.next();
                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
                        +" 学校："+resume.getSchool());

            }
            System.out.println("-------------------");

        }else {
            System.out.println("查询失败"+returnResult.failReason);
        }
    }

    private void selectResumeByName() {
        System.out.println("请输入姓名");
        Scanner scanner=new Scanner(System.in);
        String name = scanner.nextLine();
        Protocol protocol = new Protocol();
        String message = protocol.selectResumeByNameMessage(name);
        String returnMessage = client.sendMessageToSever(message);

        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        ResumeList resumeList = (ResumeList) returnResult.resultData;
        if (returnResult.isSuccess){
            System.out.println("查询成功");
            Iterator it = resumeList.iterator();
            System.out.println("----------查询结果---------");
            while (it.hasNext()){

                Resume resume = (Resume) it.next();
                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
                        +" 学校："+resume.getSchool());

            }
            System.out.println("-------------------");

        }else {
            System.out.println("查询失败"+returnResult.failReason);
        }
    }

    private void selectResumeById() {
        System.out.println("请输入身份证号码");
        Scanner scanner=new Scanner(System.in);
        String id = scanner.nextLine();

        Protocol protocol = new Protocol();
        String message = protocol.selectResumeByIdMessage(id);
        String returnMessage = client.sendMessageToSever(message);

        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        ResumeList resumeList = (ResumeList) returnResult.resultData;
        if (returnResult.isSuccess){
            System.out.println("查询成功");
            Iterator it = resumeList.iterator();
            System.out.println("----------查询结果---------");
            while (it.hasNext()){

                Resume resume = (Resume) it.next();
                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
                        +" 学校："+resume.getSchool());

            }
            System.out.println("-------------------");

        }else {
            System.out.println("查询失败"+returnResult.failReason);
        }

//        HRSService hrsService = new HRSService();
//        ResumeList resumeList = hrsService.selectResuemById(id);
//        if (resumeList.size() == 0){
//            System.out.println("没有该用户");
//        }else {

//        }

    }


    //所有简历
    public void selectAllResume() {
        Protocol protocol = new Protocol();
        String message = protocol.selectAllResumeMessage();
        String returnMessage = client.sendMessageToSever(message);

        Parser parser = new Parser();
        ReturnResult returnResult = parser.parserSearch(returnMessage);
        ResumeList resumeList = (ResumeList) returnResult.resultData;
        Iterator it = resumeList.iterator();
        System.out.println("----------查询结果---------");
        while (it.hasNext()){

            Resume resume = (Resume) it.next();
            System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
                        +" 学校："+resume.getSchool());

        }
        System.out.println("-------------------");
        //DataOperate.saveData(resumeList);
    }

    public void Closenet(String str)
    {
        String returnMessage=client.sendMessageToSever(str);
        client.closeClient();
    }
}
