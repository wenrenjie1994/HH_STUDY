package main.service.interfaces;

import main.dto.Result;
import main.entity.Resume;

/**
 * @author: hqweay
 * @description: 通过 ResumeResultService 返回结果集
 * Created on 7/15/20 12:04 PM
 */
public interface ResumeService {


  Result saveResume(Resume resume);

  Result removeResume(Resume resume);

  Result updateResume(Resume resume, Resume newResume);

  Result getResumeByID(Resume resume);

  Result listResume();
}
