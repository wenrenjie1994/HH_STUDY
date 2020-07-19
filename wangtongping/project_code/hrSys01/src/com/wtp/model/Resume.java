package com.wtp.model;

public class Resume {
    private int id; // 简历编号
    private String name; // 姓名
    private int age; // 年龄
    private int sex; // 性别：0-男性，1-女性
    private String school; // 学校
    private String major; // 专业
    private String tel; // 电话
    private String email; // 邮箱
    private int status; // 应聘状态：0-网申、1-简历通过、2-笔试通过、3-面试通过、4-已签约、5-已入职

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public String getSchool() {
        return school;
    }

    public String getMajor() {
        return major;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Resume(int id, String name, int age, int sex, String school, String major, String tel, String email, int status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.school = school;
        this.major = major;
        this.tel = tel;
        this.email = email;
        this.status = status;
    }

    public Resume(){

    }
}
