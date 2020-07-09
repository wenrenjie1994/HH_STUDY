package main.service;

import main.dto.Result;
import main.dto.ResumeList;
import main.entity.AbstractResume;
import main.entity.Resume;
import main.mapper.AbstractResumeMapper;
import main.mapper.MemoryResumeMapper;
import main.service.interfaces.ResumeService;

import java.util.Scanner;

/**
 * @author: hqweay
 * @description: 实现 Resume 在 Service 的操作
 * Created on 7/4/20 11:49 AM
 */
public class ResumeServiceImpl implements ResumeService {
  // 都得从上层传入
  private Scanner scanner;
  private AbstractResumeMapper resumeMapper;

  public ResumeServiceImpl(AbstractResumeMapper resumeMapper) {
    this.resumeMapper = resumeMapper;
  }

  public MemoryResumeMapper getResumeMapper() {
    return (MemoryResumeMapper) resumeMapper;
  }

  public void setScanner(Scanner scanner) {
    this.scanner = scanner;
  }

  @Override
  public void saveResume() {
    System.out.println("====输入姓名");
    String name = scanner.nextLine();

    System.out.println("====输入身份证号");
    String id = scanner.nextLine();

    System.out.println("====输如学校名");
    String school = scanner.nextLine();

    Resume resume = new Resume();
    resume.setName(name);
    resume.setId(id);
    resume.setSchool(school);

    if (resumeMapper.saveResume(resume).getResultCode().getCode() == 200) {
      System.out.println("success====添加成功");
    } else if (resumeMapper.saveResume(resume).getResultCode().getCode() == 501) {
      System.out.println("error====添加失败，确保每项信息都不为空～");
    } else if (resumeMapper.saveResume(resume).getResultCode().getCode() == 502) {
      System.out.println("error====数据已经存在");
    }
  }

  @Override
  public void removeResume() {
    System.out.println("====输入需要删除的简历的身份证号");
    String id = scanner.nextLine();
    Resume resume = new Resume();
    resume.setId(id);
    Result result = resumeMapper.getResumeByID(resume);
    // if (result.getResultCode().getCode() == 503) {
    //   System.out.println("warn:====没有该用户的简历");
    //   return;
    // }
    if (resumeMapper.removeResume((Resume) result.getData()).getResultCode().getCode() == 200) {
      System.out.println("info:====删除 " + ((Resume) result.getData()).getName() + " " + ((Resume) result.getData()).getId() + " 成功！");
    } else {
      System.out.println("warn:====没有该用户的简历");
    }
  }

  @Override
  public void updateResume() {
    System.out.println("====输入需要修改的简历的身份证号");
    String id = scanner.nextLine();
    Resume resume = new Resume();
    resume.setId(id);

    Result result = resumeMapper.getResumeByID(resume);
    Resume oldResume = (Resume) result.getData();
    if (oldResume == null) {
      System.out.println("====没有该用户的简历");
      return;
    }

    System.out.println("====输入姓名，留空则不变。");
    String newName = scanner.nextLine();
    newName = newName.equals("") ? oldResume.getName() : newName;

    System.out.println("====输入身份证号，留空则不变。");
    String newId = scanner.nextLine();
    newId = newId.equals("") ? oldResume.getId() : newId;

    System.out.println("====输如学校名，留空则不变。");
    String newSchool = scanner.nextLine();
    newSchool = newSchool.equals("") ? oldResume.getSchool() : newSchool;

    Resume newResume = new Resume();
    newResume.setName(newName);
    newResume.setId(newId);
    newResume.setSchool(newSchool);

    Integer code = resumeMapper.updateResume(oldResume, newResume).getResultCode().getCode();
    if (code == 200) {
      System.out.println("====修改成功");
    } else if (code == 502) {
      System.out.println("====修改后的数据与已有数据重复");
    } else if (code == 503) {
      System.out.println("====没找到该用户");
    }
  }

  @Override
  public void getResumeByID() {
    System.out.println("====输入身份证号");
    String id = scanner.nextLine();
    Resume resume = new Resume();
    resume.setId(id);

    Result result = resumeMapper.getResumeByID(resume);
    Integer code = result.getResultCode().getCode();
    Resume newResume = (Resume) result.getData();

    if (code == 503) {
      System.out.println("====没查到");
    } else {
      System.out.println(newResume.toString());
    }
  }

  @Override
  public void listResume() {
    if (resumeMapper.listResume().getResultCode().getCode() == 503) {
      System.out.println("error====还没有数据");
      return;
    }
    System.out.println("====姓名====身份证号====学校====应聘流程");
    for (AbstractResume resume : (ResumeList) resumeMapper.listResume().getData()) {
      System.out.println(resume.toString());
    }
  }
}
