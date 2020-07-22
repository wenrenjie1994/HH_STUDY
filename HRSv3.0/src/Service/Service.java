package Service;

import Domain.Resume;
import dao.Dao;

import java.util.List;
import java.util.Scanner;

/*
    接收control层的数据
    传递给dao层
 */
public class Service {
    private Dao dao = new Dao();
    /*
        1.增加简历信息
     */
    public void addResume(Resume resume){
        dao.addResume(resume);
    }
    /*
        2.修改简历信息
     */
    public void editResume(Resume resume){
        dao.editResume(resume);
    }
    /*
        3.删除简历信息
     */
    public void deleteResume(String id){
        dao.deleteResume(id);
    }
    /*
        4.查询所有学生的简历
     */
    public void selectAll(){
        List<Resume> list = dao.selectAll();
        System.out.println("——————————以下是所有学生的简历——————————");
        show(list);
    }
    /*
        5. 查询指定学生的简历
     */
    public void select(){
        System.out.println("请输入想要查询的学生id：");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        //如果isExist返回值是true说明list是空的
        if(isExist(id)){
            System.out.println("——————————抱歉！找不到对应的简历信息！——————————");
        }else{
            show(dao.select(id));
        }

    }
    /*
        6.判断id是否存在，true为不存在
     */
    public boolean isExist(String id){
        List<Resume> list = dao.select(id);
        return(list==null || list.isEmpty());
    }

    /*
        7.打印简历
     */
    public void show(List<Resume> list){
        //表头
        System.out.println("序号\t\tid\t\t姓名\t\t学校\t\t\t邮箱");
        //遍历集合，输出信息
        for (Resume rs:list) {
            System.out.println(rs.getSerialid()+"\t\t"+rs.getId()+"\t\t"
                    +rs.getName()+"\t\t"+rs.getSchool()+"\t\t"+rs.getEmail());
        }
    }
}
