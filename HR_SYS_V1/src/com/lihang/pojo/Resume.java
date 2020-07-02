package com.lihang.pojo;


public class Resume {

    /**
     *姓名
     */
    private String name;
    /**
     *身份证号
     */
    private String id;
    /**
     *学校
     */
    private String school;
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
    private Integer process;//不能用int,默认为0

    /**
    *逻辑删除
     * 0 : bu zhanshi
     * 1  展示
    */
    private Integer deleteStatus;

    public Resume(String name, String id, String school, Integer process, Integer deleteStatus) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = process;
        this.deleteStatus = deleteStatus;
    }

    public Resume() {
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", school='" + school + '\'' +
                ", process=" + process +
                ", deleteStatus=" + deleteStatus +
                '}';
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
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getProcess() {
        return process;
    }

    public void setProcess(Integer process) {
        this.process = process;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
