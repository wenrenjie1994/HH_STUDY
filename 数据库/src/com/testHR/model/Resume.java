package com.testHR.model;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class Resume {
    private String name;
    private Integer id;
    private String school;
    private Integer process;
    private Integer deleteStatus;

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
}
