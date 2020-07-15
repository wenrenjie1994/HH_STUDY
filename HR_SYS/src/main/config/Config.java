package main.config;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/9/20 12:24 PM
 */
public class Config {
  private boolean localPersistence = false;
  private boolean useDB = false;
  private boolean isCS = false;

  public Config() {
  }

  public boolean isCS() {
    return isCS;
  }

  public Config setCS(boolean CS) {
    this.isCS = CS;
    return this;
  }

  public boolean isLocalPersistence() {
    return localPersistence;
  }

  public Config setLocalPersistence(boolean localPersistence) {
    this.localPersistence = localPersistence;
    return this;
  }

  public boolean isUseDB() {
    return useDB;
  }

  public Config setUseDB(boolean useDB) {
    this.useDB = useDB;
    return this;
  }
}
