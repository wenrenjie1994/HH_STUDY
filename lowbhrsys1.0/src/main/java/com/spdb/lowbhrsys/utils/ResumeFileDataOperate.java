package com.spdb.lowbhrsys.utils;

import com.spdb.lowbhrsys.bean.ResumeBean;
import java.io.*;
import java.util.List;

/**
 * @author: libobo
 * @create: 2020-07-04 14:14
 * @description: 在txt文件中存取数据
 **/
public class ResumeFileDataOperate {
    /**
     * 用于将txt文件中的数据转换为对象放入内存中
     * @param list
     */
    public void downloadData(List<ResumeBean> list){
        //这个try...with...resource方式可以不用手动关流，会自动关
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/lowbhrsys.txt"))) {
            //先读取一行数据
            String data = br.readLine();
            while (data!=null){//说明有数据,将数据解析封装成对象
                String[] dataArr = data.split(",");
                int resumeId=Integer.parseInt(dataArr[0]);
                String name=dataArr[1];
                String id=dataArr[2];
                String sex=dataArr[3];
                String school=dataArr[4];
                String email=dataArr[5];
                String phone=dataArr[6];
                int status=Integer.parseInt(dataArr[7]);
                ResumeBean resume=new ResumeBean(name,id,sex,school,email,phone);
                resume.setResumeId(resumeId);
                resume.setStatus(status);
                list.add(resume);
                data=br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于将内存中的数据放入txt文件中
     * @param list
     */
    public void saveData(List<ResumeBean> list){
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("src/main/resources/lowbhrsys.txt", false)),true)) {
            for (ResumeBean r:
                 list) {
                String dataStr=r.getResumeId()+","+r.getName()+","+r.getId()+","+r.getSex()+","+r.getSchool()+","+r.getEmail()+","+r.getPhone()+","+r.getStatus();
                pw.println(dataStr);//因为创建对象时第二个参数是true，所以自动flush
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        ResumeFileDataOperate re=new ResumeFileDataOperate();
////        re.saveData(ResumeMemory.list);
//        re.downloadData(ResumeMemory.list);
//        ResumeMemory.list.forEach(System.out::println);
//    }
}
