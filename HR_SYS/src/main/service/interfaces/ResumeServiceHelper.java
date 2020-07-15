package main.service.interfaces;

import main.entity.Resume;

/**
 * @author: hqweay
 * @description: TODO
 * Created on 7/15/20 11:40 AM
 */
public interface ResumeServiceHelper {
  void saveResume(Resume resume);

  void removeResume(Resume resume);

  void updateResume(Resume resume, Resume newResume);

  void getResumeByID(Resume resume);

  void listResume();
}
