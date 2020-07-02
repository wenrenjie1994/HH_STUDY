package main.mapper;

import main.mapper.interfaces.ResumeMapper;
import main.entity.AbstractResume;
import main.entity.ResumeList;

/**
 * @author: hqweay
 * @description: 对数据操作进行抽象，可以从内存、可以从文本
 * Created on 7/2/20 12:01 PM
 */
public class AbstractResumeMapper implements ResumeMapper {
  @Override
  public boolean saveResume(AbstractResume resume) {
    return false;
  }

  @Override
  public boolean removeResume(AbstractResume resume) {
    return false;
  }

  @Override
  public boolean updateResume(AbstractResume resume) {
    return false;
  }

  @Override
  public AbstractResume getResume(AbstractResume resume) {
    return null;
  }

  @Override
  public ResumeList listResume() {
    return null;
  }
}
