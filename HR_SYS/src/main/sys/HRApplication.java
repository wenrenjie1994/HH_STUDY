package main.sys;

import main.db.AbstractResumeDB;
import main.db.MemoryResumeDB;
import main.db.interfaces.ResumeDB;
import main.entity.AbstractResume;
import main.entity.ResumeList;

import java.util.Scanner;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/2/20 12:48 PM
 */
public class HRApplication extends AbstractHRApplication {

  public static void main(String[] args) {
    new HRApplication().run();
  }

  public HRApplication() {
    //  配置？
  }
}
