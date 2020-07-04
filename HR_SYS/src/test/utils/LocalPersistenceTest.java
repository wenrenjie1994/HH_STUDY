package test.utils;

import main.dto.ResumeList;
import main.utils.LocalPersistence;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/4/20 10:49 AM
 */
public class LocalPersistenceTest {
  public static void main(String[] args) {
    // ResumeList list = new ResumeList();
    // list.add(new Resume("ss", "ff", "ss", ProcessEnum.PASS_APPLICATION, false));
    // list.add(new Resume("sfs", "fsaf", "ss", ProcessEnum.PASS_APPLICATION, false));
    // list.add(new Resume("ssdffs", "fssafaf", "ss", ProcessEnum.PASS_APPLICATION, false));
    //
    // LocalPersistence persistence = new LocalPersistence();
    // persistence.saveToLocal(list);
    //
    // ProcessEnum ss = ProcessEnum.PASS_APPLICATION;
    // ss.setProcess(3);
    // System.out.println(ss.toString());
    ResumeList list = new LocalPersistence().getFromLocal();
    list.forEach(System.out::println);
  }
}
