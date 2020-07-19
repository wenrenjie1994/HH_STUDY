package main.service;

import main.dto.Result;
import main.entity.Resume;
import main.mapper.AbstractResumeMapper;
import main.mapper.MemoryResumeMapper;
import main.sys.client.request.interfaces.Request;
import main.utils.ParamGetter;
import main.view.TerminalView;

import java.util.Scanner;

/**
 * @author: hqweay
 * @description: 实现 Resume 在 Service 的操作
 * Created on 7/4/20 11:49 AM
 */
public class TerminalResumeServiceImpl implements Request {
  // 都得从上层传入
  private Scanner scanner;
  private AbstractResumeMapper resumeMapper;
  private ParamGetter paramGetter;
  // private TerminalResumeServiceHelperImpl resumeServiceHelper;

  private TerminalView terminalView = new TerminalView();

  public TerminalResumeServiceImpl(AbstractResumeMapper resumeMapper) {
    this.resumeMapper = resumeMapper;
    paramGetter = new ParamGetter(scanner);
  }

  public MemoryResumeMapper getResumeMapper() {
    return (MemoryResumeMapper) resumeMapper;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }


  @Override
  public void saveResume() {
    Resume resume = paramGetter.saveResume();
    Result result = resumeMapper.saveResume(resume);
    terminalView.saveResume(result);
  }

  @Override
  public void removeResume() {
    Resume resume = paramGetter.removeResume();
    Result result = resumeMapper.getResumeByID(resume);
    terminalView.removeResume(result);
  }

  @Override
  public void updateResume() {
    Resume resume = paramGetter.getResumeByID();
    Result result = resumeMapper.getResumeByID(resume);
    Resume oldResume = (Resume) result.getData();
    if (oldResume == null) {
      System.out.println("====没有该用户的简历");
      return;
    }
    Resume newResume = paramGetter.updateResume(oldResume);
    result = resumeMapper.updateResume(oldResume, newResume);
    terminalView.updateResume(result);
  }

  @Override
  public void getResumeByID() {
    Resume resume = paramGetter.getResumeByID();
    Result result = resumeMapper.getResumeByID(resume);
    terminalView.getResumeByID(result);
  }

  @Override
  public void listResume() {
    Result result = resumeMapper.listResume();
    terminalView.listResume(result);
  }
}
