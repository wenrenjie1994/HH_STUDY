package interaction;

import bean.Request;
import bean.Resume;

import java.util.LinkedList;

public class Parser {
    private String[] message;
    private String head;
    private String data;
    private Request request;

    public Request parseStr(String str) {
        message = str.split("/n");
        head = message[0];
        data = message[1];
        request = new Request();
        request.setHead(head);
        if (head.equals("add")) {
            LinkedList<Resume> resumes = parseAdd(data);
            request.setData(resumes);
        } else if (head.equals("delete")) {
            LinkedList<Resume> resumes = parseDelete(data);
            request.setData(resumes);
        } else if (head.equals("update")) {
            LinkedList<Resume> resumes = parseUpdate(data);
            request.setData(resumes);
        } else if (head.equals("searchByName")) {
            LinkedList<Resume> resumes = parseSearchByName(data);
            request.setData(resumes);
        } else if (head.equals("searchById")) {
            LinkedList<Resume> resumes = parseSearchById(data);
            request.setData(resumes);
        }
        return request;
    }

    /**
     * 解析-->添加简历信息字符串
     *
     * @param data
     * @return
     */
    private LinkedList<Resume> parseAdd(String data) {
        String[] str = data.split(",");
        Resume resume = new Resume(str[0], str[1], str[2]);
        resume.setProcess(Integer.parseInt(str[3]));
        resume.setDeleteStatus(Integer.parseInt(str[4]));
        LinkedList<Resume> resumes = new LinkedList<>();
        resumes.add(resume);
        return resumes;
    }

    /**
     * 解析-->删除简历信息字符串
     *
     * @param data
     * @return
     */
    private LinkedList<Resume> parseDelete(String data) {
        Resume resume = new Resume(null, data, null);
        LinkedList<Resume> resumes = new LinkedList<>();
        resumes.add(resume);
        return resumes;
    }

    /**
     * 解析-->更新简历信息字符串
     *
     * @param data
     * @return
     */
    private LinkedList<Resume> parseUpdate(String data) {
        String[] str = data.split(";");
        String[] oldStr = str[1].split(",");
        String[] newStr = str[0].split(",");
        Resume oldResume = new Resume(oldStr[0], oldStr[1], oldStr[2]);
        Resume newResume = new Resume(newStr[0], newStr[1], newStr[2]);
        oldResume.setProcess(Integer.parseInt(oldStr[3]));
        oldResume.setDeleteStatus(Integer.parseInt(oldStr[4]));
        newResume.setProcess(Integer.parseInt(newStr[3]));
        newResume.setDeleteStatus(Integer.parseInt(newStr[4]));
        LinkedList<Resume> resumes = new LinkedList<>();
        resumes.add(oldResume);
        resumes.add(newResume);
        return resumes;
    }

    /**
     * 解析-->查找简历（通过姓名）信息字符串
     *
     * @param data
     * @return
     */
    private LinkedList<Resume> parseSearchByName(String data) {
        Resume resume = new Resume(data,null,null);
        LinkedList<Resume> resumes = new LinkedList<>();
        resumes.add(resume);
        return resumes;
    }

    /**
     * 解析-->查找简历（通过身份证号）信息字符串
     *
     * @param data
     * @return
     */
    private LinkedList<Resume> parseSearchById(String data) {
        Resume resume = new Resume(null,data,null);
        LinkedList<Resume> resumes = new LinkedList<>();
        resumes.add(resume);
        return resumes;
    }
}
