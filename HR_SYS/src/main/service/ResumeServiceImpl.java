package main.service;

import main.dto.Result;
import main.entity.Resume;
import main.mapper.AbstractResumeMapper;
import main.service.interfaces.ResumeService;

/**
 * @author: hqweay
 * @description: 这个类的效果似乎直接通过 ResumeMapper 就可以达到
 * Created on 7/15/20 12:05 PM
 */
public class ResumeServiceImpl implements ResumeService {
  // 由 ResumeServiceHelperImpl 传入
  private AbstractResumeMapper resumeMapper;

  public ResumeServiceImpl(AbstractResumeMapper resumeMapper) {
    this.resumeMapper = resumeMapper;
  }

  @Override
  public Result saveResume(Resume resume) {
    return resumeMapper.saveResume(resume);
  }

  @Override
  public Result removeResume(Resume resume) {
    return resumeMapper.removeResume(resume);
  }

  @Override
  public Result updateResume(Resume resume, Resume newResume) {
    return resumeMapper.updateResume(resume, newResume);
  }

  @Override
  public Result getResumeByID(Resume resume) {
    return resumeMapper.getResumeByID(resume);
  }

  @Override
  public Result listResume() {
    return resumeMapper.listResume();
  }
}
