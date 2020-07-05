package sys;

import bean.Candidate;
import bean.CandidateList;

import java.util.Scanner;

public class HRS {

    private int MAXSIZE=100;

    private Candidate[] candidates=new Candidate[MAXSIZE];
    //private CandidateList Candidates=new CandidateList();

    private int canditeCount=0;

    private Scanner input=new Scanner(System.in);

    HRS(){

        while (true){

            System.out.println("-----欢迎进入浦发招聘系统-----");
            System.out.println("添加应聘者信息请按1");
            System.out.println("删除应聘者信息请按2");
            System.out.println("查询应聘者信息请按3");
            System.out.println("退出请按4");

            int choice=input.nextInt();

            if(choice==4){
                System.out.println("你已退出系统");
                input.close();
                break;
            }

            switch (choice){
                case 1:
                    addcandidate();
                    break;
                case  2:
                    deleteCandidate();
                    break;
                case  3:
                    searchCandidate();
                    break;



            }

        }



    }

    //添加应聘者信息
    void addcandidate(){
        System.out.println("欢迎进入应聘者添加页面");
        if(canditeCount<MAXSIZE){
            Scanner input=new Scanner(System.in);
            System.out.println("请依次输入应聘者姓名、身份证号码、学校、流程");
            String name=input.nextLine();
            String id=input.nextLine();
            String school=input.nextLine();
            int process=input.nextInt();

            Candidate candidate=new Candidate(name,id,school,process);

            candidates[canditeCount]=candidate;
            canditeCount++;
            System.out.println("你已成功添加应聘者信息");

        }else {
            System.out.println("系统已满，无法添加");
        }



    }

    //删除应聘者信息
    void deleteCandidate(){
        System.out.println("欢迎进入删除应聘者信息界面");
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要删除的应聘者信息");
        String name=input.nextLine();

        if(canditeCount!=0){
            for(int i=0;i<canditeCount;i++){
                if(candidates[i].getName().equals(name)){
                    for(int j=i;j<canditeCount-1;j++){
                        candidates[j]=candidates[j+1];
                    }
                    System.out.println("你已成功删除该应聘者信息");
                    canditeCount--;
                }else if(i==canditeCount-1){
                    System.out.println("未找到该应聘者");
                }
            }
        }else{
            System.out.println("无应聘者");
        }

      // input.close();

    }

    //查找应聘者信息
    void searchCandidate(){
        System.out.println("欢迎进入查找应聘者信息界面");
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要查找的应聘者信息");
        String name=input.nextLine();
        if(canditeCount>0){
            for(int i=0;i<canditeCount;i++){
                if(candidates[i].getName().equals(name)){
                    System.out.println("姓名："+candidates[i].getName()+"  身份证号码："+candidates[i].getId()+
                            "  学校："+candidates[i].getSchool()+"  流程："+candidates[i].getProcess());
                }else if(i==canditeCount-1){
                    System.out.println("未找到该应聘者");
            }

            }
        }else{
            System.out.println("无应聘者");
        }
    }

    public static void main(String[] args) {
        new HRS();
    }


}
