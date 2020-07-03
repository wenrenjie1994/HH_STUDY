package main.mapper.interfaces;

import main.entity.AbstractResume;
import main.entity.ResumeList;

/**
 * @author: hqweay
 * @description: 数据操作方法的定义
 * Created on 7/2/20 12:00 PM
 */
public interface ResumeMapper {
  boolean saveResume(AbstractResume resume);
  boolean removeResume(AbstractResume resume);
  boolean updateResume(AbstractResume oldResume, AbstractResume newResume);
  AbstractResume getResume(AbstractResume resume);
  ResumeList listResume();
}
