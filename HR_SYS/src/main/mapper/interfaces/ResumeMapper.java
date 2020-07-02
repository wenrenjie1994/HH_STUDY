package main.mapper.interfaces;

import main.entity.Resume;
import main.entity.ResumeList;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/2/20 11:45 AM
 */
@Deprecated
public interface ResumeMapper {
  boolean saveResume(Resume resume);
  boolean removeResume(Resume resume);
  boolean updateResume(Resume resume);
  Resume getResume(Resume resume);
  ResumeList listResume();
}
