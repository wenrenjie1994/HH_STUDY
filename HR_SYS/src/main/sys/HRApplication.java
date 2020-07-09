package main.sys;

import main.config.Config;

/**
 * @author: hqweay
 * @description: 启动类
 * Created on 7/2/20 12:48 PM
 */
public class HRApplication extends AbstractHRApplication {

  public static void main(String[] args) {
    // 当 localPersistence 为 false、useDB 为 false，使用内存保存数据且不持久化
    // 当 localPersistence 为 true、useDB 为 false，使用内存保存数据并使用 txt 文件持久化
    // 只要 useDB 为 true，使用数据库读写数据，不考虑持久化
    new HRApplication(new Config(false, true)).run();
  }

  public HRApplication() {
    super();
  }

  public HRApplication(Config config) {
    super(config);
  }
}
