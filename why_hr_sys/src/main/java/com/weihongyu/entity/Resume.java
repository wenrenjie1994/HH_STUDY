package com.weihongyu.entity;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/6 11:33
 * @Description:
 */
public class Resume {

    private String name;
    private String id;
    private String school;

    /**
     * 简历状态
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
     * 是否前台展示（仅前台，数据库保留）
     * 0 : 不展示
     * 1 ：展示
     */
    private Integer showStatus;

    public Resume() {
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

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
