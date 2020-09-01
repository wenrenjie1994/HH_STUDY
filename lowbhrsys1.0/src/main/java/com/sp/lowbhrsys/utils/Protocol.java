package com.sp.lowbhrsys.utils;

import com.sp.lowbhrsys.bean.ResumeBean;

import java.util.List;

/**
 * @author: libobo
 * @create: 2020-07-14 20:44
 * @description: 封装客户端与服务端的协议
 **/
public class Protocol {

    public String protocolClient(String message){
        return message;
    }
    /**
     * 封装客户端需要发送给服务器端的信息
     * @param message
     * @param list 存放个别数据的集合
     * @return
     */
    public String protocolClient(String message,List list){
        String resultStr=message+"/";
        for (Object o:
             list) {
            resultStr+=o+"&";
        }
        return resultStr;
    }

    /**
     * 封装客户端需要发送给服务器端的信息
     * @param message
     * @param resume
     * @return
     */
    public String protocolClient(String message,ResumeBean resume){
        String resultStr=message+"/";
        resultStr+=resume.getName()+"&"+resume.getId()+"&"+resume.getSex()+"&"+resume.getSchool()
        +"&"+resume.getEmail()+"&"+resume.getPhone();
        return resultStr;
    }

    /**
     * 封装服务器端需要返回给客户端的信息
     * @param responseData
     * @return
     */
    public String protocolServer(ResponseData responseData){
        String resultStr=responseData.getCode()+"/"+responseData.getMsg();
        if (responseData.getData()!=null){
            if (responseData.getData() instanceof ResumeBean){
                ResumeBean resume= (ResumeBean) responseData.getData();
                resultStr+="/"+resume.getResumeId()+","+resume.getName()+","+resume.getId()+","+resume.getSex()+","+resume.getSchool()
                        +","+resume.getEmail()+","+resume.getPhone()+","+resume.getStatus();
            }else if(responseData.getData() instanceof List){
                List<ResumeBean> list= (List<ResumeBean>) responseData.getData();
                resultStr+="/";
                for (ResumeBean resume:
                     list) {
                    resultStr+=resume.getResumeId()+","+resume.getName()+","+resume.getId()+","+resume.getSex()+","+resume.getSchool()
                            +","+resume.getEmail()+","+resume.getPhone()+","+resume.getStatus()+"&";
                }
            }
        }
        return resultStr;
    }
}
