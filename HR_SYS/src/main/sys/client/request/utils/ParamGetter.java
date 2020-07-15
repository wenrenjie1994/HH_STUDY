package main.sys.client.request.utils;

import main.entity.Resume;

import java.util.Scanner;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 5:21 PM
 */
public class ParamGetter {

  private Scanner scanner;

  public ParamGetter() {
  }

  public ParamGetter(Scanner scanner) {
    this.scanner = scanner;
  }

  public Resume saveResume() {
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

    return resume;
  }

  public Resume removeResume() {
    System.out.println("====输入需要删除的简历的身份证号");
    String id = scanner.nextLine();
    Resume resume = new Resume();
    resume.setId(id);
    return resume;
  }

  public Resume updateResume(Resume oldResume) {
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
    return newResume;
  }

  public Resume getResumeByID() {
    System.out.println("====输入身份证号");
    String id = scanner.nextLine();
    Resume resume = new Resume();
    resume.setId(id);
    return resume;
  }

}
