package main.sys;

import main.config.Config;
import main.mapper.DBResumeMapper;
import main.mapper.MemoryResumeMapper;
import main.service.TerminalResumeServiceImpl;
import main.sys.client.request.AbstractRequest;
import main.sys.client.request.Request;
import main.sys.interfaces.HRApplication;
import main.utils.LocalPersistence;

import java.util.Scanner;

/**
 * @author: hqweay
 * @description: 对启动类的功能进行实现
 * Created on 7/2/20 1:13 PM
 */
public abstract class AbstractHRApplication implements HRApplication {

  // 由启动类的构造方法传入
  Config config;

  Scanner scanner = new Scanner(System.in);
  LocalPersistence localPersistence = new LocalPersistence();
  private boolean exitFlag = false;
  TerminalResumeServiceImpl resumeService;

  // 通过 request 与服务端交互
  AbstractRequest request;

  public AbstractHRApplication() {
  }

  public AbstractHRApplication(Config config) {
    this.config = config;
  }

  // 初始化应用
  @Override
  public void applicationInit() {

    if (config.isCS()) {
      request = new Request(new DBResumeMapper(), scanner);
      return;
    }

    if (config.isUseDB()) {
      resumeService = new TerminalResumeServiceImpl(new DBResumeMapper());
    } else if (config.isLocalPersistence()) {
      // 初始化 Service，从本地读取数据并使用持久化
      resumeService = new TerminalResumeServiceImpl(new MemoryResumeMapper(localPersistence.getFromLocal()));
    } else {
      resumeService = new TerminalResumeServiceImpl(new MemoryResumeMapper());
    }

    resumeService.setScanner(this.scanner);

  }

  // 退出应用
  @Override
  public void applicationDestory() {
    if (config.isLocalPersistence()) {
      // 保存至本地
      localPersistence.saveToLocal(resumeService.getResumeMapper().getResumeList());
    }
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

  @Override
  public void welcome() {
    System.out.println("===============HR 管理系统================");
    System.out.println("1. 简历列表");
    System.out.println("2. 查询简历");
    System.out.println("3. 添加简历");
    System.out.println("4. 修改简历");
    System.out.println("5. 删除简历");
    System.out.println("0. 退出");
    System.out.println("===============HR 管理系统================");
  }

  @Override
  public void userOperate() {
    int choice = scanner.nextInt();
    // 接受 nextInt 后的换行符
    scanner.nextLine();

    // 模式的切换应该放在 request 的，暂且这样吧。
    switch (choice) {
      case 1:
        if (config.isCS()) {
          request.listResume();
        } else {
          resumeService.listResume();
        }
        break;
      case 2:
        if (config.isCS()) {
          request.getResumeByID();
        } else {
          resumeService.getResumeByID();
        }
        break;
      case 3:
        if (config.isCS()) {
          request.saveResume();
        } else {
          resumeService.saveResume();
        }
        break;
      case 4:
        if (config.isCS()) {
          request.updateResume();
        } else {
          resumeService.updateResume();
        }
        break;
      case 5:
        if (config.isCS()) {
          request.removeResume();
        } else {
          resumeService.removeResume();
        }
        break;
      case 0:
        exitFlag = true;
        break;
      default:
        System.out.println("warn:====请输入菜单对应的相应数字～");
        break;
    }
  }

  void chooseMode() {

  }
}
