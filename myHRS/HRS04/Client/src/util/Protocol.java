package util;

/**
 * @Author lee
 * @Date 2020/7/16 3:06 PM
 **/


import model.Resume;

public class Protocol {
    public Protocol() {

    }

    public String addResumeMessage(Resume resume) {
        String str = "addResume/n" + resume.getName() + "," + resume.getId() + "," + resume.getSchool();
        return str;
    }

    public String deleteResumeByNameMessage(Resume resume) {
        String str = "deleteResumeByName/n" + resume.getName();
        return str;
    }

    public String deleteResumeByIdMessage(Resume resume) {
        String str = "deleteResumeById/n" + resume.getId();
        return str;
    }

    public String deleteResumeBySchoolMessage(Resume resume) {
        String str = "deleteResumeBySchool/n" + resume.getSchool();
        return str;
    }


    public String searchResumeByNameMessage(Resume resume) {
        String str = "searchResumeByName/n" + resume.getName();
        return str;
    }

    public String searchResumeByIdMessage(Resume resume) {
        String str = "searchResumeById/n" + resume.getId();
        return str;
    }

    public String searchResumeBySchoolMessage(Resume resume) {
        String str = "searchResumeBySchool/n" + resume.getSchool();
        return str;
    }

    public String closeNetMessage(String string) {
        String str = string + "/n";
        return str;
    }
}

