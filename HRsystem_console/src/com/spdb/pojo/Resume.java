package com.spdb.pojo;

/**
 * @Author: A wei
 * @Date: 2020/7/1 9:55
 * @Last Modified by:
 * @last Modified date:
 * @Description: 简历对象 第一版只考虑基本信息
 */
public class Resume {

    private String name;

    private String id;

    private String school;

    private String major;

    /**
     * 0:男
     * 1：女
     **/
    private int sex;

    private String phone;

    private String email;
    /**
     *
     * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3: 面试通过
     * 4：体检通过
     * 5：背调通过
     * 6：已签约
     * 7：已入职
     */
    private int status;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public int getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public Resume(String name, String id, String school, String major, int sex, String phone, String email, int status) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.major = major;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }
}
