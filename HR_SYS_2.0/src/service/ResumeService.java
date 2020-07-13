package service;

import bean.Resume;
import dataSolve.DataSolve;

import java.util.List;

public class ResumeService {

    private static ResumeService resumeService = null;

    private List<Resume> resumes = null;

    private ResumeService(){
        resumes = DataSolve.loadData();
    }

    public static ResumeService getInstance() {
        if(resumeService == null){
            resumeService = new ResumeService();
        }
        return resumeService;
    }

    public void addResume(String name, String school, String id){
        Resume resume = new Resume(name, id, school);
        resumes.add(resume);
    }

    public void deleteResume(String id){
        for(Resume resume: resumes){
            if(resume.getId().equals(id)){
                resume.setDeleteStatus(1);
            }
        }
    }

    public void updateResume(String id, String name, String school, int process){
        for(Resume resume: resumes){
            if(resume.getId().equals(id)){
                resume.setName(name);
                resume.setSchool(school);
                resume.setProcess(process);
            }
        }
    }

    public Resume searchResume(String id){
        for(Resume resume: resumes){
            if(resume.getId().equals(id)&&resume.getDeleteStatus()!=1){
                return resume;
            }
        }
        return null;
    }

    public void destory(){
        DataSolve.saveData(resumes);
    }

}
