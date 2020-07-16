package com.testHr.model;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Resume {
    private String name;
    private Integer id;
    private String school;
    /**
     * 状态
     * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     */
    private Integer process;
    /**
     * 逻辑删除
     * 0：不展示
     * 1：展示
     */
    private Integer deleteStatus;

    public Resume(){}

    public Resume(String name, Integer id, String school) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", school='" + school + '\'' +
                ", process=" + process +
                ", deleteStatus=" + deleteStatus +
                '}';
    }

    public void show() {
        System.out.println("Resume{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", school='" + school + '\'' +
                ", process=" + process +
                '}');
    }
}
