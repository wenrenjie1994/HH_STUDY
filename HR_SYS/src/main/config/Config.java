package main.config;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 12:24 PM
 */
public class Config {
  private boolean localPersistence = true;
  private boolean useDB = true;

  public Config(boolean localPersistence) {
    this.localPersistence = localPersistence;
  }

  public Config(boolean localPersistence, boolean useDB) {
    this.localPersistence = localPersistence;
    this.useDB = useDB;
  }

  public boolean isLocalPersistence() {
    return localPersistence;
  }

  public void setLocalPersistence(boolean localPersistence) {
    this.localPersistence = localPersistence;
  }

  public boolean isUseDB() {
    return useDB;
  }

  public void setUseDB(boolean useDB) {
    this.useDB = useDB;
  }
}
