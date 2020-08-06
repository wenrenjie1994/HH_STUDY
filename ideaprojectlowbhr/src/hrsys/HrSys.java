package hrsys;

import bean.People;
import work.Action;

import java.util.List;
import java.util.Scanner;

public class HrSys {
    public HrSys() {
        Scanner input = new Scanner(System.in);
//        主页面提示
        while(true){
            System.out.println("***********欢迎来到简历管理系统***********");
            System.out.println("简历信息录入请按----1");
            System.out.println("简历信息删除请按----2");
            System.out.println("简历信息修改请按----3");
            System.out.println("简历信息根据条件查询请按----4");
            System.out.println("所有简历信息查询请按----5");
            System.out.println("退出系统请按----0");
            int choose = input.nextInt();
            switch(choose){
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    updateResume();
                    break;
                case 4:
                    searchResume();
                    break;
                case 5:
                    searchAllResume();
                    break;
                case 0:
                    System.out.println("退出简历管理系统！");
                    System.exit(0);
                    break;
                default:
                     System.out.println("输入错误，请重新输入");
                     break;
            }
        }
    }

    //添加简历
    private void addResume() {
        System.out.println("欢迎来到简历录入界面");
        int result;
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入需要录入学生的姓名、身份证号码、学校、简历状态以及逻辑删除状态：");
        People pp = new People();
        pp.setName(input.next());
        pp.setId(input.next());
        pp.setSchool(input.next());
        pp.setProcess(input.nextInt());
        pp.setDeleteStatus(input.nextInt());
        result = Action.addResume(pp);
        if(result > 0){
            System.out.println("信息录入成功！");
        }else{
            System.out.println("信息录入失败！");
        }
    }

    private void deleteResume(){
        System.out.println("欢迎来到简历删除界面");
        int result;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的学生身份证号码：");
        String id = input.next();
        result = Action.deleteResume(id);
        if(result > 0){
            System.out.println("信息删除成功！");
        }else{
            System.out.println("信息删除失败！");
        }
    }

    private  void updateResume(){
        System.out.println("欢迎来到简历修改界面");
        System.out.println("请输入要修改简历的身份证号：");
        Scanner input = new Scanner(System.in);
        String id = input.next();
        List<People> list = null;
        list = Action.searchById(id);
        if(list.size() > 0){
            People pp = list.get(0);
            System.out.println("请输入修改后的学生姓名、身份证号、毕业院校、简历进程以及逻辑删除状态：");
            pp.setName(input.next());
            pp.setId(input.next());
            pp.setSchool(input.next());
            pp.setProcess(input.nextInt());
            pp.setDeleteStatus(input.nextInt());
            int result = Action.updateResume(pp,id);
            if(result > 0){
                System.out.println("信息修改成功！");
            }else{
                System.out.println("信息修改失败！");
            }
        }else{
            System.out.println("该身份证所对应的简历不存在!");
        }
    }

    private  void searchResume(){

        while(true) {
            System.out.println("欢迎来到简历查询界面");
            System.out.println("按学生姓名查询请输入-----1");
            System.out.println("按学生身份证查询请输入-----2");
            System.out.println("按学生毕业院校查询请输入-----3");
            System.out.println("按学生简历进程查询请输入-----4");
            System.out.println("模糊查询请输入-----5");
            System.out.println("退出请按-----0");
            int choose;
            Scanner sc = new Scanner(System.in);
            choose = sc.nextInt();
            switch(choose){
                case 1:
                    searchByName();
                    break;
                case 2:
                    searchById();
                    break;
                case 3:
                    SearchBySchool();
                    break;
                case 4:
                    searchByProcess();
                    break;
                case 5:
                    searchByLikeName();
                    break;
                default:
                    break;
            }
            if(choose == 0){
                break;
            }
        }
    }

    private void searchByLikeName(){
        System.out.println("请输入要查询的学生姓名关键字：");
        Scanner sc = new Scanner(System.in);
        int size;
        String key = sc.next();
        List<People> list = null;
        list = Action.searchByLikeName(key);
        size = list.size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.println("姓名" + list.get(i).getName() + "   " + "身份证号" + list.get(i).getId() + "   " + "学校" + list.get(i).getSchool() + "   " + "简历状态" + list.get(i).getProcess() + "   " + "逻辑删除状态" + list.get(i).getDeleteStatus());
            }
        }else{
            System.out.println("不存在学生姓名关键字为"+key+"的简历信息");
        }
    }

    private void searchByProcess(){
        System.out.println("请输入要查询的学生简历状态：");
        Scanner sc = new Scanner(System.in);
        int size;
        int process = sc.nextInt();
        List<People> list = null;
        list = Action.searchByProcess(process);
        size = list.size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.println("姓名" + list.get(i).getName() + "   " + "身份证号" + list.get(i).getId() + "   " + "学校" + list.get(i).getSchool() + "   " + "简历状态" + list.get(i).getProcess() + "   " + "逻辑删除状态" + list.get(i).getDeleteStatus());
            }
        }else{
            System.out.println("不存在学生简历状态为"+process+"的简历信息");
        }
    }

    private void SearchBySchool() {
        System.out.println("请输入要查询的学生毕业学校：");
        Scanner sc = new Scanner(System.in);
        int size;
        String school = sc.next();
        List<People> list = null;
        list = Action.searchBySchool(school);
        size = list.size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.println("姓名" + list.get(i).getName() + "   " + "身份证号" + list.get(i).getId() + "   " + "学校" + list.get(i).getSchool() + "   " + "简历状态" + list.get(i).getProcess() + "   " + "逻辑删除状态" + list.get(i).getDeleteStatus());
            }
        }else{
            System.out.println("不存在学生毕业学校为"+school+"的简历信息");
        }
    }

    private void searchByName() {
        System.out.println("请输入要查询的学生姓名：");
        Scanner sc = new Scanner(System.in);
        int size;
        String name = sc.next();
        List<People> list = null;
        list = Action.searchByName(name);
        size = list.size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.println("姓名" + list.get(i).getName() + "   " + "身份证号" + list.get(i).getId() + "   " + "学校" + list.get(i).getSchool() + "   " + "简历状态" + list.get(i).getProcess() + "   " + "逻辑删除状态" + list.get(i).getDeleteStatus());
            }
        }else{
            System.out.println("不存在学生姓名为"+name+"的简历信息");
        }

    }

    private void searchById(){
        System.out.println("请输入要查询的学生身份证号：");
        Scanner sc = new Scanner(System.in);
        int size;
        String id = sc.next();
        List<People> list = null;
        list = Action.searchById(id);
        size = list.size();
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                System.out.println("姓名" + list.get(i).getName() + "   " + "身份证号" + list.get(i).getId() + "   " + "学校" + list.get(i).getSchool() + "   " + "简历状态" + list.get(i).getProcess() + "   " + "逻辑删除状态" + list.get(i).getDeleteStatus());
            }
        }else{
            System.out.println("不存在学生身份证号为"+id+"的简历信息");
        }
    }

    private void searchAllResume(){
        System.out.println("目前数据库中所有简历信息如下所示：");
        List<People> list = null;
        list = Action.searchAllResume();
        int size;
        size = list.size();
        if(size > 0){
            for(int i=0;i<size;i++){
                System.out.println("姓名"+list.get(i).getName()+"   "+"身份证号"+list.get(i).getId()+"   "+"学校"+list.get(i).getSchool()+"   "+"简历状态"+list.get(i).getProcess()+"   "+"逻辑删除状态"+list.get(i).getDeleteStatus());
            }
        }else{
            System.out.println("数据库中目前没有简历信息！");
        }

    }

    public static void main(String[] args) {
        new HrSys();
    }
}
