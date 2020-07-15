package com.spdb.lowbhrsys.utils;

import com.spdb.lowbhrsys.bean.ResumeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: libobo
 * @create: 2020-07-14 20:44
 * @description: 解析协议
 **/
public class Parser {

    /**
     * 解析客户端发送过来的信息，以/分割，数据部分使用&分割
     * 若只有1个元素则只有 描述
     * 若有2个元素则有 描述和数据
     * @return
     */
    public ResponseData<String[]> parserClient(String str){
        ResponseData<String[]> responseData=new ResponseData<String[]>();
        String[] arr=str.split("/");
        responseData.setMsg(arr[0]);//设置描述信息
        if (arr.length==2){//解析数据
            String[] dataArr = arr[1].split("&");
            responseData.setData(dataArr);
        }
        return responseData;
    }

    /**
     * 解析服务器端返回的信息以/分割
     * 若只有2个元素则只有 响应码、描述
     * 若有3个元素则有 响应码、描述、数据（多个数据元素使用&分割，数据的属性使用,分割）
     * @return
     */
    public ResponseData<List<ResumeBean>> parserServer(String str){
        ResponseData<List<ResumeBean>> responseData=new ResponseData();
        String[] arr=str.split("/");
        int code= Integer.parseInt(arr[0]);
        String message=arr[1];
        responseData.setCode(code);
        responseData.setMsg(message);
        if (arr.length==3){
            String[] dataArr = arr[2].split("&");
            List<ResumeBean> list=new ArrayList<>();
            for (int i = 0; i < dataArr.length; i++) {
                ResumeBean resume=new ResumeBean();
                String[] filedArr = dataArr[i].split(",");
                resume.setResumeId(Integer.parseInt(filedArr[0]));
                resume.setName(filedArr[1]);
                resume.setId(filedArr[2]);
                resume.setSex(filedArr[3]);
                resume.setSchool(filedArr[4]);
                resume.setEmail(filedArr[5]);
                resume.setPhone(filedArr[6]);
                resume.setStatus(Integer.parseInt(filedArr[7]));
                list.add(resume);
            }
            responseData.setData(list);
        }
        return responseData;
    }

//    public static void main(String[] args) {
//        ResponseData responseData=ResponseData.returnSuccess();
//        List<ResumeBean> list=new ArrayList<>();
//        ResumeBean resume=new ResumeBean("libobo","5115261997","男","sicau","174@qq.com","133515");
//        ResumeBean resume2=new ResumeBean("libobo2","5115261","男","sicau","174@qq.com","133515");
//        list.add(resume);
//        list.add(resume2);
//        responseData.setData(list);
//        Protocol protocol=new Protocol();
//        String s = protocol.protocolServer(responseData);
//        System.out.println(s);
//        Parser parser=new Parser();
//        ResponseData data = parser.parserServer(s);
//        System.out.println(data);
//    }
}
