package main.sys;

import main.mapper.MemoryResumeMapper;
import main.service.ResumeServiceImpl;
import main.sys.interfaces.HRApplication;
import main.utils.LocalPersistence;

import java.util.Scanner;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/2/20 1:13 PM
 */
public abstract class AbstractHRApplication implements HRApplication {
  Scanner scanner = new Scanner(System.in);
  LocalPersistence localPersistence = new LocalPersistence();
  private boolean exitFlag = false;
  ResumeServiceImpl resumeService;

  // 初始化应用
  @Override
  public void applicationInit() {
    // 初始化 Service，从本地读取数据
    resumeService = new ResumeServiceImpl(new MemoryResumeMapper(localPersistence.getFromLocal()));
    resumeService.setScanner(this.scanner);
  }

  // 退出应用
  @Override
  public void applicationDestory() {
    // 保存至本地
    localPersistence.saveToLocal(resumeService.getResumeMapper().getResumeList());
    // 关闭输入
    scanner.close();
  }

  @Override
  public void run() {
    applicationInit();
    while (true) {
      welcome();
      userOperate();
      if (exitFlag == true) {
        System.out.println("info:=====退出咯～");
        break;
      }
    }
    applicationDestory();
  }

  void welcome() {
    System.out.println("===============HR 管理系统================");
    System.out.println("1. 简历列表");
    System.out.println("2. 查询简历");
    System.out.println("3. 添加简历");
    System.out.println("4. 修改简历");
    System.out.println("5. 删除简历");
    System.out.println("0. 退出");
    System.out.println("===============HR 管理系统================");
  }

  void userOperate() {
    int choice = scanner.nextInt();
    // 接受 nextInt 后的换行符
    scanner.nextLine();
    switch (choice) {
      case 1:
        resumeService.listResume();
        break;
      case 2:
        resumeService.getResume();
        break;
      case 3:
        resumeService.saveResume();
        break;
      case 4:
        resumeService.updateResume();
        break;
      case 5:
        resumeService.removeResume();
        break;
      case 0:
        exitFlag = true;
        break;
      default:
        System.out.println("warn:====请输入菜单对应的相应数字～");
        break;
    }
  }
}
