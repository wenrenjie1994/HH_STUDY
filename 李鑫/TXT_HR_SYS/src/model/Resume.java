package model;

/*

 */

public class Resume {

    private String name;  // 学生名字
    private String id;  // 学生身份证号
    private String school;  // 学校名

    /**
     *
     * * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     */
    private int status;  // 学生招聘流程中的状态
    private int displayStatus; // 简历显示状态，1：不显示，0：显示，暂未实现

    public Resume(String name, String id, String school) {
        this.name = name;
        this.id = id;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
