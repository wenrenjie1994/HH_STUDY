package main.sys.interfaces;

/**
 * @author: hqweay
 * @description: 定义应用生命周期
 * Created on 7/2/20 1:12 PM
 */
public interface HRApplication {
  //初始化
  void applicationInit();

  //退出
  void applicationDestory();

  void run();

  //引导界面
  void welcome();

  //用户交互
  void userOperate();

}
