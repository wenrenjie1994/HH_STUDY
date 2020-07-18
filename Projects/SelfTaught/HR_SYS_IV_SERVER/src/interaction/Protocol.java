package interaction;

import bean.Response;
import bean.Resume;

import java.util.LinkedList;

public class Protocol {
    /**
     * 添加简历--反馈信息字符串构建
     *
     * @param response
     * @return
     */
    public String addResumeMessage(Response response) {
        if ("Succeed".equals(response.getIsSuccess())) return "Succeed/n";
        else return "Failed/n" + response.getFailReason();
    }

    /**
     * 删除简历--反馈信息字符串构建
     *
     * @param response
     * @return
     */
    public String deleteResumeMessage(Response response) {
        if ("Succeed".equals(response.getIsSuccess())) return "Succeed/n";
        else return "Failed/n" + response.getFailReason();
    }

    /**
     * 更新简历--反馈信息字符串构建
     *
     * @param response
     * @return
     */
    public String updateResumeMessage(Response response) {
        if ("Succeed".equals(response.getIsSuccess())) return "Succeed/n";
        else return "Failed/n" + response.getFailReason();
    }

    /**
     * 查找简历--反馈信息字符串构建
     *
     * @param response
     * @return
     */
    public String searchResume(Response response) {
        if ("Succeed".equals(response.getIsSuccess())) {
            String str = "Succeed/n";
            LinkedList<Resume> resumes = (LinkedList<Resume>) response.getData();
            for (Resume resume : resumes) {
                str += resume.getName() + "," + resume.getId() + "," + resume.getSchool() + "," + resume.getProcess() + "," + resume.getDeleteStatus() + ";";
            }
            return str;
        } else return "Failed/n" + response.getFailReason();
    }
}
