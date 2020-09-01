package com.sp.lowbhrsys.bean;

import com.sp.lowbhrsys.utils.ResumeStatusEnum;

/**
 * @author: libobo
 * @create: 2020-07-03 12:50
 * @description: 简历实体类
 **/
public class ResumeBean {
    /**
     * 简历ID,对应数据库中的主键
     */
    private int resumeId;
    private String name;
    /**
     * 身份证
     */
    private String id;
    private String sex;
    private String school;
    private String email;
    private String phone;
    /**
     * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3: 面试通过
     * 4：体检通过
     * 5：背调通过
     * 6：已签约
     * 7：已入职
     *
     * 默认已申请
     */
    private int status= ResumeStatusEnum.APPLIED.getStatus();

    public ResumeBean() {
    }

    public ResumeBean(String name, String id, String sex, String school, String email, String phone) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.school = school;
        this.email = email;
        this.phone = phone;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public String toString() {
        return "ResumeBean{" +
                "resumeId=" + resumeId +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
