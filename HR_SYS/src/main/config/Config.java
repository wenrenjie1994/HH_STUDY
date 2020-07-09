package main.config;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 12:24 PM
 */
public class Config {
  private boolean localPersistence = true;

  public Config(boolean localPersistence) {
    this.localPersistence = localPersistence;
  }

  public boolean isLocalPersistence() {
    return localPersistence;
  }

  public void setLocalPersistence(boolean localPersistence) {
    this.localPersistence = localPersistence;
  }
}
