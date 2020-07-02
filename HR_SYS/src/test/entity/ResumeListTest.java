package test.entity;

import main.entity.AbstractResume;
import main.entity.Resume;
import main.entity.ResumeList;
import main.enums.ProcessEnum;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/2/20 12:06 PM
 */
public class ResumeListTest {
  public static void main(String[] args) {
    ResumeList list = new ResumeList();
    list.add(new Resume("ss","ff","ss", ProcessEnum.PASS_APPLICATION, 0));

    for(AbstractResume resume : list){
      System.out.println(resume.getProcess());
    }
    AbstractResume resume = new Resume("sss","ff","ss", ProcessEnum.PASS_APPLICATION, 0);
    System.out.println(list.add(resume));

    // for(AbstractResume res : list){
    //   System.out.println(resume.getProcess());
    //   list.remove(res);
    // }
    System.out.println("还有吗");
    for(AbstractResume res : list){
      System.out.println(resume.getSchool());
      // list.remove(res);
    }

  }
}
