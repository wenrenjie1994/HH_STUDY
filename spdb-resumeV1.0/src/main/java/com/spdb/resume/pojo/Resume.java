package com.spdb.resume.pojo;

import java.util.Date;

public class Resume {
    private Integer id;

    private String name;

    private String idCardNumber;

    private String school;

    private String major;

    private Integer sex;

    private String email;

    private String phone;

    private Integer status;

    private Date createTime;

    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber == null ? null : idCardNumber.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Resume(Integer id, String name, String idCardNumber, String school, String major, Integer sex, String email, String phone, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.idCardNumber = idCardNumber;
        this.school = school;
        this.major = major;
        this.sex = sex;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}