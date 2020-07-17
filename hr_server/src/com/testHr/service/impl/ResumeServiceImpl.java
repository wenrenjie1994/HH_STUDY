package com.testHr.service.impl;

import com.testHr.dao.ResumeDao;
import com.testHr.dao.impl.ResumeDaoImpl;
import com.testHr.dto.ResumeDTO;
import com.testHr.model.Resume;
import com.testHr.service.ResumeService;
import com.testHr.utils.Parser;
import com.testHr.utils.TransctionUtils;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class ResumeServiceImpl implements ResumeService {
    ResumeDao resumeDao = new ResumeDaoImpl();
    @Override
    public ResumeDTO dealWith(String message, PrintWriter out) {
        ResumeDTO resumeDTO = new ResumeDTO();
        try {
            TransctionUtils.startTransction();
            resumeDTO = Parser.parserMessage(message);//解析消息，进行数据库操作
            if("add".equals(resumeDTO.getHead())){
                if(resumeDao.insert(resumeDTO.getResume()) > 0){
                    resumeDTO.setSuccess(true);
                } else {
                    resumeDTO.setReturnfailMessage("添加失败");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                }
            } else if ("updateDeleteStatus".equals(resumeDTO.getHead())){
                resumeDTO.setHead("delete");//删除信息头为"delete"
                if(resumeDao.updateDeleteStatus(resumeDTO.getResume().getId()) > 0){
                    resumeDTO.setSuccess(true);
                } else {
                    resumeDTO.setReturnfailMessage("拉黑失败");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                }
            } else if("delete".equals(resumeDTO.getHead())){
                if(resumeDao.delete(resumeDTO.getResume().getId()) > 0){
                    resumeDTO.setSuccess(true);
                } else {
                    resumeDTO.setReturnfailMessage("删除失败");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                }
            } else if("update".equals(resumeDTO.getHead())){
                if(resumeDao.update(resumeDTO.getResume(),resumeDTO.getInputId()) > 0){
                    resumeDTO.setSuccess(true);
                } else {
                    resumeDTO.setReturnfailMessage("修改失败");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                }
            } else if("queryAll".equals(resumeDTO.getHead())){
                resumeDTO.setHead("query");//查询统一设置头为"query"
                List<Resume> resumeList = resumeDao.queryAll();
                if(resumeList == null || resumeList.size() == 0){
                    resumeDTO.setReturnfailMessage("尚未录入信息");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                } else {
                    resumeDTO.setSuccess(true);
                    String body = "";
                    for (Resume resume : resumeList) {
                        body = body+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";";
                    }
                    resumeDTO.setBody(body);
                }
            } else if("queryEffList".equals(resumeDTO.getHead())){
                resumeDTO.setHead("query");//查询统一设置头为"query"
                List<Resume> resumeList = resumeDao.queryEffList();
                if(resumeList == null || resumeList.size() == 0){
                    resumeDTO.setReturnfailMessage("未查询到结果");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                } else {
                    resumeDTO.setSuccess(true);
                    String body = "";
                    for (Resume resume : resumeList) {
                        body = body+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";";
                    }
                    resumeDTO.setBody(body);
                }
            } else if("queryBlackList".equals(resumeDTO.getHead())){
                resumeDTO.setHead("query");//查询统一设置头为"query"
                List<Resume> resumeList = resumeDao.queryBlackList();
                if(resumeList == null || resumeList.size() == 0){
                    resumeDTO.setReturnfailMessage("未查询到结果");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                } else {
                    resumeDTO.setSuccess(true);
                    String body = "";
                    for (Resume resume : resumeList) {
                        body = body+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";";
                    }
                    resumeDTO.setBody(body);
                }
            } else if("queryByName".equals(resumeDTO.getHead())){
                resumeDTO.setHead("query");//查询统一设置头为"query"
                List<Resume> resumeList = resumeDao.queryByName(resumeDTO.getResume().getName());
                if(resumeList == null || resumeList.size() == 0){
                    resumeDTO.setReturnfailMessage("未查询到结果");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                } else {
                    resumeDTO.setSuccess(true);
                    String body = "";
                    for (Resume resume : resumeList) {
                        body = body+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";";
                    }
                    resumeDTO.setBody(body);
                }
            } else if("queryById".equals(resumeDTO.getHead())){
                resumeDTO.setHead("query");//查询统一设置头为"query"
                Resume resume = resumeDao.queryById(resumeDTO.getResume().getId());
                if(resume == null){
                    resumeDTO.setReturnfailMessage("未查询到结果");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                } else {
                    resumeDTO.setSuccess(true);
                    String body = "";
                    body = body+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";";
                    resumeDTO.setBody(body);
                }
            } else if("queryBySchool".equals(resumeDTO.getHead())){
                resumeDTO.setHead("query");//查询统一设置头为"query"
                List<Resume> resumeList = resumeDao.queryBySchool(resumeDTO.getResume().getSchool());
                if(resumeList == null || resumeList.size() == 0){
                    resumeDTO.setReturnfailMessage("未查询到结果");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                } else {
                    resumeDTO.setSuccess(true);
                    String body = "";
                    for (Resume resume : resumeList) {
                        body = body+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";";
                    }
                    resumeDTO.setBody(body);
                }
            } else if("queryByProcess".equals(resumeDTO.getHead())){
                resumeDTO.setHead("query");//查询统一设置头为"query"
                List<Resume> resumeList = resumeDao.queryByProcess(resumeDTO.getResume().getProcess());
                if(resumeList == null || resumeList.size() == 0){
                    resumeDTO.setReturnfailMessage("未查询到结果");
                    resumeDTO.setBody(resumeDTO.getReturnfailMessage());
                    throw new RuntimeException(resumeDTO.getReturnfailMessage());
                } else {
                    resumeDTO.setSuccess(true);
                    String body = "";
                    for (Resume resume : resumeList) {
                        body = body+resume.getName()+","+resume.getId()+","+resume.getSchool()+","+resume.getProcess()+","+resume.getDeleteStatus()+";";
                    }
                    resumeDTO.setBody(body);
                }
            } else if ("over".equals(resumeDTO.getHead())){
                resumeDTO.setHead("over");//查询统一设置头为"query"
                resumeDTO.setBody("服务器：已收到你的关闭信息");
            } else {
                resumeDTO.setHead("false");
                throw new RuntimeException("service:解析失败");
            }
            TransctionUtils.commit();
        } catch (Exception e) {
            try {
                TransctionUtils.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            resumeDTO.setReturnfailMessage(e.getMessage());//记录异常信息
            resumeDTO.setBody(resumeDTO.getReturnfailMessage());
            e.printStackTrace();
        }
        return resumeDTO;
    }
}
