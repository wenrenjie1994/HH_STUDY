package com.testHr.utils;

import com.testHr.dto.ResumeDTO;
import com.testHr.model.Resume;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Parser {
    public static ResumeDTO parserMessage(String message) throws Exception {
        String[] messages = message.split("\\:");
        if("add".equals(messages[0])){
            return parserAdd(messages[1]);
        } else if ("updateDeleteStatus".equals(messages[0])){
            return parserUpdateDeleteStatus(messages[1]);
        } else if("delete".equals(messages[0])){
            return parserDelete(messages[1]);
        } else if("update".equals(messages[0])){
            return parserUpdate(messages[1]);
        } else if("queryAll".equals(messages[0])){
            return parserQueryAll();
        } else if("queryEffList".equals(messages[0])){
            return parserQueryEffList();
        } else if("queryBlackList".equals(messages[0])){
            return parserQueryBlackList();
        } else if("queryByName".equals(messages[0])){
            return parserQueryByName(messages[1]);
        } else if("queryById".equals(messages[0])){
            return parserQueryById(messages[1]);
        } else if("queryBySchool".equals(messages[0])){
            return parserQueryBySchool(messages[1]);
        } else if("queryByProcess".equals(messages[0])){
            return parserQueryByProcess(messages[1]);
        } else if("over".equals(messages[0])){
            return parserOver();
        }else {
            try {
                throw new RuntimeException("Parser:解析失败");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    private static ResumeDTO parserOver() {
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("over");
        return resumeDTO;
    }

    private static ResumeDTO parserQueryByProcess(String message) throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("queryByProcess");
        Resume resume = new Resume();
        resume.setProcess(Integer.parseInt(message));
        resumeDTO.setResume(resume);
        return resumeDTO;
    }

    private static ResumeDTO parserQueryBySchool(String message) throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("queryBySchool");
        Resume resume = new Resume();
        resume.setSchool(message);
        resumeDTO.setResume(resume);
        return resumeDTO;
    }

    private static ResumeDTO parserQueryById(String message) throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("queryById");
        Resume resume = new Resume();
        resume.setId(Integer.parseInt(message));
        resumeDTO.setResume(resume);
        return resumeDTO;
    }

    private static ResumeDTO parserQueryByName(String message) throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("queryByName");
        Resume resume = new Resume();
        resume.setName(message);
        resumeDTO.setResume(resume);
        return resumeDTO;
    }

    private static ResumeDTO parserQueryBlackList() throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("queryBlackList");
        return resumeDTO;
    }

    private static ResumeDTO parserQueryEffList() throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("queryEffList");
        return resumeDTO;
    }

    private static ResumeDTO parserQueryAll() throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("queryAll");
        return resumeDTO;
    }

    private static ResumeDTO parserUpdate(String message) throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("update");
        String[] properties = message.split("\\,");
        Resume resume = new Resume();
        resume.setName(properties[0]);
        resume.setId(Integer.parseInt(properties[1]));
        resume.setSchool(properties[2]);
        resume.setProcess(Integer.parseInt(properties[3]));
        resumeDTO.setResume(resume);
        resumeDTO.setInputId(Integer.parseInt(properties[4]));
        return resumeDTO;
    }

    private static ResumeDTO parserDelete(String message) throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("delete");
        Integer inputId = Integer.parseInt(message);
        Resume resume = new Resume();
        resume.setId(inputId);
        resumeDTO.setResume(resume);
        return resumeDTO;
    }

    private static ResumeDTO parserUpdateDeleteStatus(String message) throws Exception{
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("updateDeleteStatus");
        Integer inputId = Integer.parseInt(message);
        Resume resume = new Resume();
        resume.setId(inputId);
        resumeDTO.setResume(resume);
        return resumeDTO;
    }

    private static ResumeDTO parserAdd(String message) throws Exception {
        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setHead("add");
        String[] properties = message.split("\\,");
        Resume resume = new Resume();
        resume.setName(properties[0]);
        resume.setId(Integer.parseInt(properties[1]));//如果转换异常，则head头信息被丢失
        resume.setSchool(properties[2]);
        resumeDTO.setResume(resume);
        return resumeDTO;
    }
}
