package utils;

import model.Resume;

/**
 * @program: HR_SYS_4.0（C/S模式）
 * @className:Protocol
 * @description:客户端协议（字符串）生成器（用来生成发送到服务器端的客户端协议）
 * @author: 何文艺
 * @create: 2020/7/19 9:57
 **/
public class Protocol {
    public Protocol() {

    }

    public String addResumeMessage(Resume resume) {
        return "add/n" + resume.name + "," + resume.id + "," + resume.school;
    }

    public String deleteResumeMessage(Resume resume) {
        return "delete/n" + resume.id;
    }

    public String updateResumeMessage(Resume newResume, Resume oldResume) {
        return "update/n" + newResume.name + "," + newResume.id + "," + newResume.school + ";" +
                oldResume.name + "," + oldResume.id + "," + oldResume.school;
    }

    public String searchByNameMessage(Resume resume) {
        return "searchByName/n" + resume.name;
    }

    public String searchByIdMessage(Resume resume) {
        return "searchById/n" + resume.id;
    }

    public String searchBySchoolMessage(Resume resume) {
        return "searchBySchool/n" + resume.school;
    }

    public String searchByProcessMessage(Resume resume) {
        return "searchByProcess/n" + resume.process;
    }

    public String searchAllMessage() {
        return "searchAll/n0";
    }

}
