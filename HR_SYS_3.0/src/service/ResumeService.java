package service;

import bean.Resume;
import dao.ResumeDao;

import java.util.List;

public class ResumeService {

    private static ResumeService resumeService = null;

    private ResumeDao resumeDao = ResumeDao.getInstance();

    private ResumeService(){}

    public static ResumeService getInstance() {
        if(resumeService == null){
            resumeService = new ResumeService();
        }
        return resumeService;
    }

    public void addResume(String name, String school, String id){
        Resume resume = new Resume(id, name, school, 0, 0);
        resumeDao.addResume(resume);
    }

    public void deleteResume(String id){
        resumeDao.deleteResume(id);
    }

    public void updateResume(String id, String name, String school, int process){
        Resume resume = new Resume(id, name, school, process, 0);
        resumeDao.updateResume(resume);
    }

    public Resume searchResume(String id){
        List<Resume> resumes = resumeDao.selectResumeById(id);
        if(resumes!= null && !resumes.isEmpty()){
            return resumes.get(0);
        }
        return null;
    }
}
