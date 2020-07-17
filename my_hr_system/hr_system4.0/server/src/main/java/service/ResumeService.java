package service;



import en.OperationEnum;
import en.StatusEnum;
import model.Response;
import model.Resume;

import java.util.List;

/**
 * @Author: chenlei
 * @Date: 2020/7/12 18:16
 */
public class ResumeService<T> {
     Response addResume(Resume info) {
        Resume exitResume = findResume(info.getName());
        if(exitResume != null) {
            return Response.error(StatusEnum.RESUME_EXIT,OperationEnum.ADD);
        }else{
            if(DatabaseService.addResume(info)) {
                return Response.success(OperationEnum.ADD);
            }else{
                return Response.error(StatusEnum.DATABASE_ERROR,OperationEnum.ADD);
            }
        }
    }
    Response deleteResume(String name){
        Resume resume = findResume(name);
        if(resume != null) {
            if(DatabaseService.deleteResume(name)) {
                return Response.success(OperationEnum.DELETE);
            }else{
                return Response.error(StatusEnum.RESUME_NOT_EXIT,OperationEnum.DELETE);
            }
        }else {
            return Response.error(StatusEnum.RESUME_NOT_EXIT,OperationEnum.DELETE);
        }
    }
    Response updateResume(Resume r){
        Resume resume = findResume(r.getName());
        if(resume != null) {
            if(DatabaseService.updateResume(r)) {
                return Response.success(OperationEnum.UPDATE);
            }else{
                return Response.error(StatusEnum.DATABASE_ERROR,OperationEnum.UPDATE);
            }
        }else {
            return Response.error(StatusEnum.RESUME_NOT_EXIT,OperationEnum.UPDATE);
        }
    }
    Response showAllResume(){
        List<Resume> resumeList = DatabaseService.selectAllResume();
        if(resumeList.size() == 0) {
            return Response.error(StatusEnum.NO_RESUME_EXIT,OperationEnum.SELECT_ALL);
        }else {
            return Response.success(resumeList,OperationEnum.SELECT_ALL);
        }
    }

    Response searchResume(String name){
        Resume resume = findResume(name);
        if(resume == null) {
            return Response.error(StatusEnum.RESUME_NOT_EXIT,OperationEnum.SELECT);
        }else {
            return Response.success(resume,OperationEnum.SELECT);
        }
    }
    private Resume findResume(String name) {
        return DatabaseService.selectByName(name);
    }

    private void  copy(Resume from, Resume to) {
        if(from!= null && to!= null) {
            to.setName(from.getName());
            to.setJob(from.getJob());
            to.setYear(from.getYear());
        }
    }
}
