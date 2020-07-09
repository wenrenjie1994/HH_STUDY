package main.mapper;

import main.dto.Result;
import main.dto.ResumeList;
import main.entity.AbstractResume;
import main.utils.Validator;

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
    if (!Validator.validResumeAllFields(resume)) {
      return Result.errorParamValidResult();
    }
    if (hasResume(resume)) {
      AbstractResume oldResume = getResumeById(resume.getId());
      // 如果已经逻辑删除，那就实际删除了再添加吧。
      if (oldResume.getDeleteStatus()) {
        removeResumeById(resume.getId());
      } else {
        return Result.errorIsExistResult();
      }
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
        resumeList.get(i).setDeleteStatus(true);
        return Result.successResult();
      }
    }
    return Result.errorNotFoundResult();
  }

  @Override
  public Result updateResume(AbstractResume oldResume, AbstractResume newResume) {
    // oldId 用于修改时查找匹配
    String oldId = oldResume.getId();
    //  前置判断
    if (!Validator.validResumeAllFields(newResume) || oldId == null || oldId.equals("")) {
      return Result.errorParamValidResult();
    }


    // 判断 newResume 是否重复
    // for (AbstractResume res : resumeList) {
    //   if (res.getId().equals(newResume.getId())) {
    //     if (res.getDeleteStatus()) {
    //       // resumeList.remove(res);
    //       // 已经逻辑删除了
    //       break;
    //     } else {
    //       return Result.errorIsExistResult();
    //     }
    //   }
    // }

    // 如果修改前的 resume ID 与修改后一致，就不存在 更改后的简历与已有简历重复了
    if (!oldResume.getId().equals(newResume.getId())) {
      // 判断 newResume 是否重复
      for (int i = 0; i < resumeList.size(); i++) {
        if (resumeList.get(i).getId().equals(newResume.getId())) {
          if (resumeList.get(i).getDeleteStatus()) {
            resumeList.remove(i);
            break;
          } else {
            return Result.errorIsExistResult();
          }
        }
      }
    }

    for (int i = 0; i < resumeList.size(); i++) {
      if (resumeList.get(i).getId().equals(oldId)) {
        if (resumeList.get(i).getDeleteStatus()) {
          // 已经删除了，不能更新。
          return Result.errorNotFoundResult();
        } else {
          resumeList.set(i, newResume);
          return Result.successResult();
        }
      }
    }
    //没找到
    return Result.errorNotFoundResult();
  }

  @Override
  public Result getResumeByID(AbstractResume oldResume) {
    if (!Validator.validResumeID(oldResume)) {
      return null;
    }
    for (AbstractResume res : resumeList) {
      if (res.getId().equals(oldResume.getId())) {
        if (res.getDeleteStatus()) {
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
      if (!resume.getDeleteStatus()) {
        newList.add((resume));
      }
    }
    if (newList.size() == 0) {
      return Result.errorNotFoundResult();
    }
    return Result.successResult(newList);
  }

  // private boolean isDeleted(int deleteStatus) {
  //   return deleteStatus == 0 ? true : false;
  // }

  private boolean hasResume(AbstractResume resume) {
    for (AbstractResume res : resumeList) {
      if (res.getId().equals(resume.getId())) {
        return true;
      }
    }
    return false;
  }

  private void removeResumeById(String id) {
    for (int i = 0; i < resumeList.size(); i++) {
      if (resumeList.get(i).getId().equals(id)) {
        resumeList.remove(i);
      }
    }
  }

  private AbstractResume getResumeById(String id) {
    for (AbstractResume res : resumeList) {
      if (res.getId().equals(id)) {
        return res;
      }
    }
    //没找到
    return null;
  }
}
