package main.service;


import main.dto.Result;
import main.entity.Resume;
import main.mapper.AbstractResumeMapper;
import main.service.interfaces.ResumeService;
import main.service.interfaces.ResumeServiceHelper;
import main.view.TerminalView;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 11:37 AM
 */
@Deprecated
public class TerminalResumeServiceHelperImpl implements ResumeServiceHelper {
  // 由 ResumeServiceImpl 传入
  private AbstractResumeMapper resumeMapper;
  private ResumeService resumeService;

  private TerminalView terminalView = new TerminalView();

  public TerminalResumeServiceHelperImpl(AbstractResumeMapper resumeMapper) {
    this.resumeMapper = resumeMapper;
    resumeService = new ResumeServiceImpl(resumeMapper);
  }

  @Override
  public void saveResume(Resume resume) {
    Result result = resumeService.saveResume(resume);
    terminalView.saveResume(result);
  }

  @Override
  public void removeResume(Resume resume) {
    Result result = resumeService.getResumeByID(resume);
    terminalView.removeResume(result);
  }

  @Override
  public void updateResume(Resume oldResume, Resume newResume) {
    Result result = resumeService.updateResume(oldResume, newResume);
    terminalView.updateResume(result);
  }

  @Override
  public void getResumeByID(Resume resume) {
    Result result = resumeService.getResumeByID(resume);
    terminalView.getResumeByID(result);
  }

  @Override
  public void listResume() {
    Result result = resumeService.listResume();
    terminalView.listResume(result);
  }
}
