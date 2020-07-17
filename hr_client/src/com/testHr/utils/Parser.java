package com.testHr.utils;

import com.testHr.dto.ResumeDTO;
import com.testHr.model.Resume;

/**
 * @description: message解析器。message[0]是信息头,[1]是成功与否,[2]是信息体
 * @author: zeng
 * @modified By:
 */
public class Parser {
    public static ResumeDTO parseMessage(String message){
        String[] messages = message.split("\\-");
        ResumeDTO resumeDTO = new ResumeDTO();
        if("add".equals(messages[0])){
            return parserAdd(messages[1],messages[2]);
        } else if ("delete".equals(messages[0])){
            return parserDelete(messages[1],messages[2]);
        } else if("update".equals(messages[0])){
            return parserUpdate(messages[1],messages[2]);
        } else if("query".equals(messages[0])){
           return parserQuery(messages[1], messages[2]);
        } else if("over".equals(messages[0])){
            return parserOver(messages[0], messages[2]);
        } else {
            resumeDTO.setReturnfailMessage(messages[2]);
            return resumeDTO;
        }
    }

    private static ResumeDTO parserOver(String message, String message1) {
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead(message);
        resumeDTO.setBody(message1);
        return resumeDTO;
    }

    private static ResumeDTO parserQuery(String message1, String message2) {
        ResumeDTO resumeDTO = new ResumeDTO();
        if ("true".equals(message1)){
            resumeDTO.setSuccess(true);
            String[] resumeList = message2.split("\\;");
            int resumeNum = resumeList.length;
            for (int i = 0; i < resumeNum; i++) {
                String[] properties = resumeList[i].split("\\,");
                Resume resume = new Resume();
                resume.setName(properties[0]);
                resume.setId(Integer.parseInt(properties[1]));
                resume.setSchool(properties[2]);
                resume.setProcess(Integer.parseInt(properties[3]));
                resume.setDeleteStatus(Integer.parseInt(properties[4]));
                resumeDTO.getList().add(resume);
                if(resumeNum == 1){//考虑按id查询时，返回的是一个对象
                    resumeDTO.setResume(resume);
                }
            }
        } else {
            resumeDTO.setReturnfailMessage(message2);
        }
        return resumeDTO;
    }

    private static ResumeDTO parserUpdate(String message1, String message2) {
        ResumeDTO resumeDTO = new ResumeDTO();
        if ("true".equals(message1)){
            resumeDTO.setSuccess(true);
        } else {
            resumeDTO.setReturnfailMessage(message2);
        }
        return resumeDTO;
    }

    private static ResumeDTO parserDelete(String message1, String message2) {
        ResumeDTO resumeDTO = new ResumeDTO();
        if ("true".equals(message1)){
            resumeDTO.setSuccess(true);
        } else {
            resumeDTO.setReturnfailMessage(message2);
        }
        return resumeDTO;
    }

    private static ResumeDTO parserAdd(String message1, String message2){
        ResumeDTO resumeDTO = new ResumeDTO();
        if ("true".equals(message1)){
            resumeDTO.setSuccess(true);
        } else {
            resumeDTO.setReturnfailMessage(message2);
        }
        return resumeDTO;
    }

}
