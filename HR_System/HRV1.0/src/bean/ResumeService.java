package bean;
import java.util.Scanner;
import java.util.LinkedList;
/*
* 插入、删除、更新、查询
* */
public class ResumeService {
    private ResumeList resumeList=null;
    public void insert(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("*****求职者信息录入*****");
        System.out.println("请输入求职者姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入求职者身份证号：");
        String id = scanner.nextLine();
        System.out.println("请输入求职者学校：");
        String school =scanner.nextLine();
        System.out.println("请输入求职者状态：\n" +
                "     0：已申请\n" +
                "     1：简历通过\n" +
                "     2：笔试通过\n" +
                "     3：面试通过\n" +
                "     4：体检通过\n" +
                "     5：背调通过\n" +
                "     6：已签约\n"+
                "     7：已入职");
        int process =scanner.nextInt();
        Resume resume = new Resume(name,id,school,process,1);
        resumeList.getResumeList().add(resume);
        System.out.println("信息录入成功");
    }
    public void delete(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("*****删除求职者信息******");
        System.out.println("请输入要删除的求职者的身份证号：");
        String id = scanner.nextLine();
        LinkedList <Resume> list = resumeList.getResumeList();
        Resume resume=null;
        for(Resume re:list){
            if(re.getId().equals(id)){
                resume=re;
                break;
            }
        }
        if(resume==null){
            System.out.println("没有此人信息");
        }else{
            System.out.println("请确认是否要删除此人信息，如果删除请输入1,如果不删除请输入0.");
            Scanner scanner1 =new Scanner(System.in);
            int choice = scanner1.nextInt();
            if(choice==1){
                list.remove(resume);
                System.out.println("信息删除成功");
            }
        }
    }
    public void update(){
        System.out.println("****更新求职者信息****");
        query();
        Scanner scanner =new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice==1){
            insert();
        }

    }
    public void query(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("请输入求职者的身份证号码：");
        String id = scanner.nextLine();
        LinkedList<Resume> list = resumeList.getResumeList();
        Resume resume = null;
        for(Resume re:list){
            if(re.getId().equals(id)){
                resume=re;
                break;
            }
        }
        if(resume==null){
            System.out.println("没有此人信息");
        }else{
            System.out.println("求职者信息如下：");
            System.out.println("姓名："+resume.getName()+" 身份证："+resume.getId()+" 学校："+resume.getSchool()+
                    " 当前状态："+resume.getProcess()+" 删除状态："+resume.getDeleteStatus());
        }

    }
}
