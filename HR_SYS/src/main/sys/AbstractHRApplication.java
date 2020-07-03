package main.sys;

import main.mapper.AbstractResumeMapper;
import main.mapper.MemoryResumeMapper;
import main.entity.AbstractResume;
import main.entity.Resume;
import main.sys.interfaces.HRApplication;

import java.util.Scanner;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/2/20 1:13 PM
 */
public abstract class AbstractHRApplication implements HRApplication {
  Scanner scanner = new Scanner(System.in);
  AbstractResumeMapper resumeMapper = new MemoryResumeMapper();
  private boolean exitFlag = false;

  public void run(){
    while(true){
      welcome();
      userOperate();
      if(exitFlag == true){
        System.out.println("====退出");
        break;
      }
    }
  }


  void welcome(){
    System.out.println("===============HR 管理系统================");
    System.out.println("1. 简历列表");
    System.out.println("2. 查询简历");
    System.out.println("3. 添加简历");
    System.out.println("4. 修改简历");
    System.out.println("5. 删除简历");
    System.out.println("===============HR 管理系统================");
  }
  void userOperate(){
    int choice = scanner.nextInt();
    // 接受 nextInt 后的换行符
    scanner.nextLine();
    switch (choice){
      case 1:
        listResume();
        break;
      case 2:
        getResume();
        break;
      case 3:
        saveResume();
        break;
      case 4:
        updateResume();
        break;
      case 5:
        removeResume();
        break;
      default:
        System.out.println("输入错误");
        scanner.close();
        exitFlag = true;
        break;
    }
  }

  @Override
  public void saveResume() {
    System.out.println("====输入姓名");
    String name = scanner.nextLine();

    System.out.println("====输入身份证号");
    String id = scanner.nextLine();

    System.out.println("====输如学校名");
    String school = scanner.nextLine();

    Resume resume = new Resume();
    resume.setName(name);
    resume.setId(id);
    resume.setSchool(school);

    if(resumeMapper.saveResume(resume)){
      System.out.println("success====保存成功");
    }else{
      System.out.println("error====保存失败，可能数据已经存在了～");
    }
  }

  @Override
  public void removeResume() {

  }

  @Override
  public void updateResume() {

  }

  @Override
  public void getResume() {
    System.out.println("====输入身份证号");
    String id = scanner.nextLine();
    Resume resume = new Resume();
    resume.setId(id);

    AbstractResume newResume =  resumeMapper.getResume(resume);
    if(newResume == null){
      System.out.println("====没查到");
    }else{
      System.out.println(newResume.toString());
    }
  }

  @Override
  public void listResume() {
    if(resumeMapper.listResume().size() == 0){
      System.out.println("error====还没有数据");
    }
    System.out.println("====姓名====身份证号====学校====应聘流程");
    for(AbstractResume resume : resumeMapper.listResume()){
      System.out.println(resume.toString());
    }
  }
}
