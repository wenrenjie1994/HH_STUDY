package sys;

import bean.Resume;
import bean.ResumeList;

import java.util.Iterator;
import java.util.Scanner;

public class HRS {

    //ResumeList resumeList = new ResumeList();



    //添加简历
    public static int addResume(Resume newResume) {

        HRSService hrsService = new HRSService();
        int result = hrsService.addResume(newResume);
        return result;

    }
    //删除简历
    public static int deleteResume(String id) {

        HRSService hrsService = new HRSService();
        int result = hrsService.deleteResuem(id);
        return result;

    }
    //修改简历
    public static ResumeList updateResume(String id) {

        HRSService hrsService = new HRSService();
        ResumeList resumeList = hrsService.selectResuemById(id);
        return resumeList;

    }
    //查询简历
    public static ResumeList selectResume(int choose,String str) {
        ResumeList resume_list = null;
        if (choose == 1) {
            String id = str;
            resume_list = selectResumeById(id);
        } else if (choose == 2) {
            String name = str;
            resume_list = selectResumeByName(name);
        } else if (choose == 3) {
            String school = str;
            resume_list = selectResumeBySchool(school);
        } else if (choose == 4) {
            resume_list = selectAllResume();
        } else {
        }
        return resume_list;
    }



    private static ResumeList selectResumeBySchool(String school) {
        HRSService hrsService = new HRSService();
        ResumeList resumeList = hrsService.selectResuemBySchool(school);
//        if (resumeList.size() == 0){
//            System.out.println("该学校没有用户");
//        }else {
//            Iterator it = resumeList.iterator();
//            System.out.println("----------查询结果---------");
//            while (it.hasNext()){
//
//                Resume resume = (Resume) it.next();
//                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
//                        +" 学校："+resume.getSchool());
//
//            }
//            System.out.println("-------------------");
//        }
        return resumeList;
    }

    private static ResumeList selectResumeByName(String name) {
        HRSService hrsService = new HRSService();
        ResumeList resumeList = hrsService.selectResuemByName(name);
        if (resumeList.size() == 0){
            System.out.println("没有该用户");
        }else {
            Iterator it = resumeList.iterator();
            System.out.println("----------查询结果---------");
            while (it.hasNext()){

                Resume resume = (Resume) it.next();
                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
                        +" 学校："+resume.getSchool());

            }
            System.out.println("-------------------");
        }
        return resumeList;
    }

    private static ResumeList selectResumeById(String id) {
        HRSService hrsService = new HRSService();
        ResumeList resumeList = hrsService.selectResuemById(id);
//        if (resumeList.size() == 0){
//            System.out.println("没有该用户");
//        }else {
//            Iterator it = resumeList.iterator();
//            System.out.println("----------查询结果---------");
//            while (it.hasNext()){
//
//                Resume resume = (Resume) it.next();
//                System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
//                        +" 学校："+resume.getSchool());
//
//            }
//            System.out.println("-------------------");
//        }
        return resumeList;

    }


    //所有简历
    public static ResumeList selectAllResume() {
        HRSService hrsService = new HRSService();
        ResumeList resumeList = hrsService.selectAllResuem();

//        Iterator it = resumeList.iterator();
//        System.out.println("----------查询结果---------");
//        while (it.hasNext()){
//
//            Resume resume = (Resume) it.next();
//            System.out.println(" 姓名："+resume.getName()+" 身份证："+resume.getId()
//                        +" 学校："+resume.getSchool());
//
//        }
//        System.out.println("-------------------");
//        //DataOperate.saveData(resumeList);
        return resumeList;
    }
}
