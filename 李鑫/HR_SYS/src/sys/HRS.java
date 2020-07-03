package sys;

import bean.Resume;
import bean.ResumeList;


public class HRS {

    private ResumeList resumeList = new ResumeList();

    public void addResume(Resume r) {
        resumeList.add(r);
    }

    // 通过名字删除简历
    public void delResume(String name) {
        if (resumeList.size() == 0) {
            System.out.println("内存中暂无简历信息:(");
            return;
        }
        for (int i=0; i<resumeList.size(); i++) {
            if (resumeList.get(i).getName().equals(name)) {
                resumeList.remove(i);
                System.out.println("已成功删除该简历:)");
                return;
            }
            else if (i == resumeList.size()-1) {
                System.out.println("没有找到该简历，无法删除:(");

            }
        }
    }

    // 通过查询名字来修改信息
    public void updateResume(String originalName, String newName, String newId, String newSchool) {
        if (resumeList.size() == 0) {
            System.out.println("内存中暂无简历信息:(");
            return;
        }
        for (int i=0; i<resumeList.size(); i++) {
           Resume r = resumeList.get(i);
            if (r.getName().equals(originalName)) {
                r.setName(newName);
                r.setId(newId);
                r.setSchool(newSchool);
                return;
            }
            else if (i == resumeList.size()-1) {
                System.out.println("没有找到该简历，无法修改:(");
            }
        }
    }

    // 通过名字修改招聘流程状态
    public void updateStatue(String name, int status) {
        Resume r = searchResume(name);
        if (r != null) {
            r.setStatus(status);
        }
    }

    // 通过名字查找简历并返回其引用
    public Resume searchResume (String name) {
        if (resumeList.size() == 0) {
            System.out.println("内存中暂无简历信息:(");
            return null;
        }
        for (int i=0; i<resumeList.size(); i++) {
            Resume r = resumeList.get(i);
            if (r.getName().equals(name)) {
                return r;
            }
            else if (i == resumeList.size()-1) {
                System.out.println("没有找到该简历:(");
            }
        }
        return null;
    }

    // 通过名字查找简历并打印
    public void printResume (String name) {
        if (resumeList.size() == 0) {
            System.out.println("内存中暂无简历信息:(");
            return;
        }
        for (int i=0; i<resumeList.size(); i++) {
            Resume r = resumeList.get(i);
            if (r.getName().equals(name)) {
                System.out.println(r.getName() + "的身份证号是：" + r.getId() + "，学校是：" + r.getSchool());
                return;
            }
            else if (i == resumeList.size()-1) {
                System.out.println("没有找到该简历，无法修改:(");
            }
        }
    }
}