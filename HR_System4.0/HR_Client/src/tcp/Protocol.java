package tcp;

import resume.Resume;
//发送信息协议 “\t”隔开
public class Protocol {
    public String addResumeMessage(Resume resume){
        String str = "添加简历\t"+resume.getName()+";"+resume.getId()+";"+resume.getSchool()+";"+resume.getProcess();
        return str;
    }
    public String deleteByNameMessage(Resume resume){
        String str = "通过姓名删除简历\t"+resume.getName();
        return str;
    }
    public String deleteByIdMessage(Resume resume){
        String str = "通过身份证号码删除简历\t"+resume.getId();
        return str;
    }
    public String deleteBySchoolMessage(Resume resume){
        String str = "通过学校删除简历\t"+resume.getSchool();
        return str;
    }
    public String updateMessage(Resume resume,Resume oldResume){
        String str = "更新简历信息\t"+resume.getName()+";"+resume.getId()+";"+resume.getSchool()+";"+resume.getProcess()+"/"+
                oldResume.getName()+";"+oldResume.getId()+";"+oldResume.getSchool()+";"+oldResume.getProcess();
        return  str;

    }
    public String searchByNameMessage(Resume resume){
        String str = "按照姓名查询\t"+resume.getName();
        return str;
    }
    public String searchByIdMessage(Resume resume){
        String str = "按照身份证号码查询\t"+resume.getId();
        return str;
    }public String searchBySchoolMessage(Resume resume){
        String str = "按照学校查询\t"+resume.getSchool();
        return str;
    }

}
