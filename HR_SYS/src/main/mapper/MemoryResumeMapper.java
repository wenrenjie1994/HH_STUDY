package main.mapper;

import main.entity.AbstractResume;
import main.entity.ResumeList;
import main.utils.Result;
import main.utils.Valid;

/**
 * @author: hqweay
 * @description: 基于内存对数据进行操作
 * Created on 7/2/20 12:02 PM
 */
public class MemoryResumeMapper extends AbstractResumeMapper {
  private ResumeList resumeList = new ResumeList();

  public MemoryResumeMapper(ResumeList resumeList) {
    this.resumeList = resumeList;
  }

  public MemoryResumeMapper() {
  }

  public ResumeList getResumeList() {
    return resumeList;
  }

  public void setResumeList(ResumeList resumeList) {
    this.resumeList = resumeList;
  }

  @Override
  /*
   * error: 参数、重复、其它
   * */
  public Result saveResume(AbstractResume resume) {
    // 前置判断，写个工具类吧。
    if (!Valid.ValidResumeAllFields(resume)) {
      return Result.errorParamValidResult();
    }
    if (hasResume(resume)) {
      return Result.errorIsExistResult();
    }
    if (resumeList.add(resume)) {
      return Result.successResult();
    } else {
      return Result.errorResult();
    }

  }

  @Override
  public Result removeResume(AbstractResume resume) {
    for (int i = 0; i < resumeList.size(); i++) {
      if (resumeList.get(i).getId().equals(resume.getId())) {
        // 逻辑删除
        resumeList.get(i).setDeleteStatus(0);
        return Result.successResult();
      }
    }
    return Result.errorNotFoundResult();
  }

  @Override
  public Result updateResume(AbstractResume oldResume, AbstractResume newResume) {
    //  前置判断
    String oldId = oldResume.getId();

    if (!Valid.ValidResumeAllFields(newResume) || oldId == null || oldId.equals("")) {
      return Result.errorParamValidResult();
    }

    for (AbstractResume res : resumeList) {
      if (res.getId().equals(newResume.getId())) {
        return Result.errorIsExistResult();
      }
    }

    for (int i = 0; i < resumeList.size(); i++) {
      if (resumeList.get(i).getId().equals(oldId)) {
        if (isDeleted(resumeList.get(i).getDeleteStatus())) {
          // 已经删除了，不能更新。
          return Result.errorNotFoundResult();
        } else {
          resumeList.set(i, newResume);
          Result.successResult();
        }
      }
    }
    //没找到
    return Result.errorNotFoundResult();
  }

  @Override
  public Result getResume(AbstractResume resume) {
    if (resume.getId() == null || resume.getId().trim().equals("")) {
      return null;
    }
    for (AbstractResume res : resumeList) {
      if (res.getId().equals(resume.getId())) {
        if (isDeleted(res.getDeleteStatus())) {
          //删除了
          Result.errorNotFoundResult();
        } else {
          return Result.successResult(res);
        }
      }
    }
    //没找到
    return Result.errorNotFoundResult();
  }

  @Override
  public Result listResume() {
    ResumeList newList = new ResumeList();
    for (AbstractResume resume : resumeList) {
      if (!isDeleted(resume.getDeleteStatus())) {
        newList.add((resume));
      }
    }
    if (newList.size() == 0) {
      return Result.errorNotFoundResult();
    }
    return Result.successResult(newList);
  }

  private boolean isDeleted(int deleteStatus) {
    return deleteStatus == 0 ? true : false;
  }

  private boolean hasResume(AbstractResume resume) {
    for (AbstractResume res : resumeList) {
      if (res.getId().equals(resume.getId())) {
        return true;
      }
    }
    return false;
  }
}
