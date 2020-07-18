package interaction;

import bean.Resume;

public class Protocol {
    /**
     * 添加简历信息字符串构建
     *
     * @param resume
     * @return
     */
    public String addResumeMessage(Resume resume) {
        return "add/n" + resume.getName() + "," + resume.getId() + "," + resume.getSchool() + "," +
                resume.getProcess() + "," + resume.getDeleteStatus();
    }

    /**
     * 删除简历信息字符串构建
     *
     * @param resume
     * @return
     */
    public String deleteResumeMessage(Resume resume) {
        return "delete/n" + resume.getId();
    }

    /**
     * 更新简历信息字符串构建
     *
     * @param newResume
     * @param oldResume
     * @return
     */
    public String updateResumeMessage(Resume newResume, Resume oldResume) {
        return "update/n" + newResume.getName() + "," + newResume.getId() + "," + newResume.getSchool() +
                "," + newResume.getProcess() + "," + newResume.getDeleteStatus() + ";" + oldResume.getName() +
                "," + oldResume.getId() + "," + oldResume.getSchool() + "," + oldResume.getProcess() + "," +
                oldResume.getDeleteStatus();
    }

    /**
     * 查找简历（通过姓名）信息字符串构建
     *
     * @param resume
     * @return
     */
    public String searchResumeByNameMessage(Resume resume) {
        return "searchByName/n" + resume.getName();
    }

    /**
     * 查找简历（通过身份证号）信息字符串构建
     *
     * @param resume
     * @return
     */
    public String searchResumeByIdMessage(Resume resume) {
        return "searchById/n" + resume.getId();
    }

    /**
     * 关闭网络连接信息字符串构建
     *
     * @param string
     * @return
     */
    public String closeNetMessage(String string) {
        return string + "/n";
    }
}
