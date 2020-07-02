package main.mapper;

import main.entity.Resume;
import main.entity.ResumeList;
import main.mapper.interfaces.ResumeMapper;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/2/20 11:39 AM
 */
@Deprecated
public class AbstractResumeMapper implements ResumeMapper {
  private ResumeList listResume;
  @Override
  public boolean saveResume(Resume resume) {
    return false;
  }

  @Override
  public boolean removeResume(Resume resume) {
    return false;
  }

  @Override
  public boolean updateResume(Resume resume) {
    return false;
  }

  @Override
  public Resume getResume(Resume resume) {
    return null;
  }

  @Override
  public ResumeList listResume() {
    return null;
  }
}
