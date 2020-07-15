package main.sys;

import main.config.Config;

/**
 * @author: hqweay
 * @description: 启动类
 * Created on 7/2/20 12:48 PM
 */
public class HRApplication extends AbstractHRApplication {

  public static void main(String[] args) {
    // new Config(); 内存读写
    // new Config().setLocalPersistence(true); 内存读写并持久化
    // new Config().setUseDB(true); 使用数据库
    // new Config().setCS(true); C/S 分离，需要启动 sys/ServerApplication
    // 优先级：setCS > setUseDB > setLocalPersistence > 啥都不干

    Config config = new Config().setCS(true);
    new HRApplication(config).run();
  }

  public HRApplication() {
    super();
  }

  public HRApplication(Config config) {
    super(config);
  }
}
