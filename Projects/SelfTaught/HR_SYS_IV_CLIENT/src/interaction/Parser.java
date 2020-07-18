package interaction;

import bean.Response;
import bean.Resume;

import java.util.LinkedList;

public class Parser {
    /**
     * 解析-->添加简历--反馈信息字符串
     *
     * @param data
     * @return
     */
    public Response parseAdd(String data) {
        Response response = new Response();
        String[] message = data.split("/n");
        if ("Succeed".equals(message[0])) response.setSuccess(true);
        else response.setFailReason(message[1]);
        return response;
    }

    /**
     * 解析-->删除简历--反馈信息字符串
     *
     * @param data
     * @return
     */
    public Response parseDelete(String data) {
        Response response = new Response();
        String[] message = data.split("/n");
        if ("Succeed".equals(message[0])) response.setSuccess(true);
        else response.setFailReason(message[1]);
        return response;
    }

    /**
     * 解析-->更新简历--反馈信息字符串
     *
     * @param data
     * @return
     */
    public Response parseUpdate(String data) {
        Response response = new Response();
        String[] message = data.split("/n");
        if ("Succeed".equals(message[0])) response.setSuccess(true);
        else response.setFailReason(message[1]);
        return response;
    }

    /**
     * 解析-->查找简历--反馈信息字符串
     *
     * @param data
     * @return
     */
    public Response parseSearch(String data) {
        Response response = new Response();
        String[] message = data.split("/n");
        if ("Succeed".equals(message[0])) {
            response.setSuccess(true);
            String[] resumeInfo = message[1].split(";");
            LinkedList<Resume> resumes = new LinkedList<>();
            for (int i = 0; i < resumeInfo.length; i++) {
                String[] str = resumeInfo[i].split(",");
                Resume resume = new Resume(str[0], str[1], str[2]);
                resume.setProcess(Integer.parseInt(str[3]));
                resume.setDeleteStatus(Integer.parseInt(str[4]));
                resumes.add(resume);
            }
            response.setData(resumes);
        } else {
            response.setFailReason(message[1]);
            LinkedList<Resume> resumes = new LinkedList<>();
            response.setData(resumes);
        }
        return response;
    }
}
