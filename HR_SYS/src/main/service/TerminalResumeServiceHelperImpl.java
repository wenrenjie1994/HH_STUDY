package main.service;


import main.dto.Result;
import main.dto.ResumeList;
import main.entity.AbstractResume;
import main.entity.Resume;
import main.mapper.AbstractResumeMapper;
import main.service.interfaces.ResumeService;
import main.service.interfaces.ResumeServiceHelper;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 11:37 AM
 */
public class TerminalResumeServiceHelperImpl implements ResumeServiceHelper {
  // 由 ResumeServiceImpl 传入
  private AbstractResumeMapper resumeMapper;
  private ResumeService resumeService;

  public TerminalResumeServiceHelperImpl(AbstractResumeMapper resumeMapper) {
    this.resumeMapper = resumeMapper;
    resumeService = new ResumeServiceImpl(resumeMapper);
  }

  @Override
  public void saveResume(Resume resume) {
    Result result = resumeService.saveResume(resume);

    if (result.getResultCode().getCode() == 200) {
      System.out.println("success====添加成功");
    } else if (resumeMapper.saveResume(resume).getResultCode().getCode() == 501) {
      System.out.println("error====添加失败，确保每项信息都不为空～");
    } else if (resumeMapper.saveResume(resume).getResultCode().getCode() == 502) {
      System.out.println("error====数据已经存在");
    }
  }

  @Override
  public void removeResume(Resume resume) {
    Result result = resumeService.getResumeByID(resume);
    // if (result.getResultCode().getCode() == 503) {
    //   System.out.println("warn:====没有该用户的简历");
    //   return;
    // }
    if (resumeService.removeResume((Resume) result.getData()).getResultCode().getCode() == 200) {
      System.out.println("info:====删除 " + ((Resume) result.getData()).getName() + " " + ((Resume) result.getData()).getId() + " 成功！");
    } else {
      System.out.println("warn:====没有该用户的简历");
    }
  }

  @Override
  public void updateResume(Resume oldResume, Resume newResume) {

    // Result result = resumeMapper.getResumeByID(resume);
    // Resume oldResume = (Resume) result.getData();
    // if (oldResume == null) {
    //   System.out.println("====没有该用户的简历");
    //   return;
    // }


    Integer code = resumeService.updateResume(oldResume, newResume).getResultCode().getCode();
    if (code == 200) {
      System.out.println("====修改成功");
    } else if (code == 502) {
      System.out.println("====修改后的数据与已有数据重复");
    } else if (code == 503) {
      System.out.println("====没找到该用户");
    }
  }

  @Override
  public void getResumeByID(Resume resume) {
    Result result = resumeService.getResumeByID(resume);
    Integer code = result.getResultCode().getCode();
    Resume newResume = (Resume) result.getData();

    if (code == 503) {
      System.out.println("====没查到");
    } else {
      System.out.println(newResume.toString());
    }
  }

  @Override
  public void listResume() {
    if (resumeService.listResume().getResultCode().getCode() == 503) {
      System.out.println("error====还没有数据");
      return;
    }
    System.out.println("====姓名====身份证号====学校====应聘流程");
    for (AbstractResume resume : (ResumeList) resumeService.listResume().getData()) {
      System.out.println(resume.toString());
    }
  }
}
