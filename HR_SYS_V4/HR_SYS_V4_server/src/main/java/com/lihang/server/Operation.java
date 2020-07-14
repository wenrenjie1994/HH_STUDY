package com.lihang.server;

import com.lihang.pojo.Response;
import com.lihang.pojo.Resume;
import com.lihang.service.ResumeService;
import com.lihang.service.impl.ResumeServiceImpl;
import com.lihang.util.Parse;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/7/14
 */
public class Operation {

    public Response oprate(String message) {
        Resume resume = new Resume();
        ResumeService resumeService = new ResumeServiceImpl();
        Response response = new Response();
        String[] detail = message.split("/");
        if ("add".equalsIgnoreCase(detail[0])) {
            resume = Parse.buildResume(detail[1]);
            int code = resumeService.addResume(resume);
            if (code == 1) {
                response.setCode(200);
            } else {
                response.setCode(500);
            }
        } else if ("update".equalsIgnoreCase(detail[0])) {
            resume = Parse.buildResume(detail[1]);
            int code = resumeService.updateResume(resume);
            if (code == 1) {
                response.setCode(200);
            } else {
                response.setCode(500);
            }
        } else if ("delete".equalsIgnoreCase(detail[0])) {
            int code = resumeService.deletResumeByName(detail[1]);
            if (code == 1) {
                response.setCode(200);
            } else {
                response.setCode(500);
            }
        } else if ("get".equalsIgnoreCase(detail[0])) {
            List<Resume> resumes = resumeService.getResumeByName(detail[1]);
            if (resumes == null) {
                response.setCode(500);
            } else {
                response.setCode(200);
                response.setDetail(resumes.toString());
            }
        } else{
            response.setCode(500);
            response.setDetail("请正确输入");
        }
        ;

        return response;
    }
}
