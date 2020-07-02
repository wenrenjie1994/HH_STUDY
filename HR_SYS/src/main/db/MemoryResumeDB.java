package main.db;

import main.db.AbstractResumeDB;
import main.entity.AbstractResume;
import main.entity.Resume;
import main.entity.ResumeList;
import main.utils.Valid;

/**
 * @author: hqweay
 * @description: 基于内存对数据进行操作
 * Created on 7/2/20 12:02 PM
 */
public class MemoryResumeDB extends AbstractResumeDB {
  private ResumeList resumeList = new ResumeList();

  public MemoryResumeDB(ResumeList resumeList) {
    this.resumeList = resumeList;
  }

  public MemoryResumeDB() {
  }

  public ResumeList getResumeList() {
    return resumeList;
  }

  public void setResumeList(ResumeList resumeList) {
    this.resumeList = resumeList;
  }

  @Override
  public boolean saveResume(AbstractResume resume) {
   // 前置判断，写个工具类吧。
    Valid.ValidResumeAllFields(resume);
    if(hasResume(resume)){
      return false;
    }
    return resumeList.add(resume);
  }

  @Override
  public boolean removeResume(AbstractResume resume) {
    for(int i = 0; i < resumeList.size(); i++){
      if(resumeList.get(i).getId().equals(resume.getId())){
        // 逻辑删除
        resumeList.get(i).setDeleteStatus(0);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean updateResume(AbstractResume resume) {
  //  前置判断
    Valid.ValidResumeAllFields(resume);
    for(int i = 0; i < resumeList.size(); i++){
      if(resumeList.get(i).getId().equals(resume.getId())){
        if(isDeleted(resumeList.get(i).getDeleteStatus())){
          // 已经删除了，不能更新。
          return false;
        }else{
          resumeList.set(i, resume);
          return true;
        }
      }
    }
    //没找到
    return false;
  }

  @Override
  public AbstractResume getResume(AbstractResume resume) {
    if(resume.getId() == null || resume.getId().trim().equals("")){
      return null;
    }
    for(AbstractResume res:resumeList){
      if(res.getId().equals(resume.getId())){
        if(isDeleted(res.getDeleteStatus())){
          //删除了
          return null;
        }else{
          return res;
        }
      }
    }
    //没找到
    return null;
  }

  @Override
  public ResumeList listResume() {
    ResumeList newList = new ResumeList();
    for(AbstractResume resume : resumeList){
      if(!isDeleted(resume.getDeleteStatus())){
        newList.add((resume));
      }
    }
    return newList;
  }

  private boolean isDeleted(int deleteStatus){
    return deleteStatus == 0 ? true : false;
  }
  private boolean hasResume(AbstractResume resume){
    for(AbstractResume res : resumeList){
      if(res.getId().equals(resume.getId())){
        return true;
      }
    }
    return false;
  }
}
