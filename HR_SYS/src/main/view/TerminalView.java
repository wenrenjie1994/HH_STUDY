package main.view;

import main.dto.Result;
import main.dto.ResumeList;
import main.entity.AbstractResume;
import main.entity.Resume;
import main.mapper.AbstractResumeMapper;
import main.service.ResumeServiceImpl;
import main.service.interfaces.ResumeService;
import main.view.interfaces.View;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 5:08 PM
 */
public class TerminalView implements View {
  // 由 ResumeServiceImpl 传入
  private AbstractResumeMapper resumeMapper;
  private ResumeService resumeService;

  public TerminalView(AbstractResumeMapper resumeMapper) {
    this.resumeMapper = resumeMapper;
    resumeService = new ResumeServiceImpl(resumeMapper);
  }

  @Override
  public void saveResume(Result result) {
    if (result.getResultCode().getCode() == 200) {
      System.out.println("success====添加成功");
    } else if (result.getResultCode().getCode() == 501) {
      System.out.println("error====添加失败，确保每项信息都不为空～");
    } else if (result.getResultCode().getCode() == 502) {
      System.out.println("error====数据已经存在");
    }
  }

  @Override
  public void removeResume(Result result) {
    Resume resume = (Resume) result.getData();
    System.out.println(resume);
    if (result.getResultCode().getCode() == 200) {
      System.out.println("info:====删除身份证号为 " + " " + resume.getId() + " 的用户简历成功！");
    } else {
      System.out.println("warn:====没有该用户的简历");
    }
  }

  @Override
  public void updateResume(Result result) {
    Integer code = result.getResultCode().getCode();
    if (code == 200) {
      System.out.println("====修改成功");
    } else if (code == 502) {
      System.out.println("====修改后的数据与已有数据重复");
    } else if (code == 503) {
      System.out.println("====没找到该用户");
    }
  }

  @Override
  public void getResumeByID(Result result) {
    Integer code = result.getResultCode().getCode();
    Resume newResume = (Resume) result.getData();

    if (code == 503) {
      System.out.println("====没查到");
    } else {
      System.out.println(newResume.toString());
    }
  }

  @Override
  public void listResume(Result result) {
    if (result.getResultCode().getCode() == 503) {
      System.out.println("error====还没有数据");
      return;
    }
    System.out.println("====姓名====身份证号====学校====应聘流程");
    for (AbstractResume resume : (ResumeList) result.getData()) {
      System.out.println(resume.toString());
    }
  }
}
