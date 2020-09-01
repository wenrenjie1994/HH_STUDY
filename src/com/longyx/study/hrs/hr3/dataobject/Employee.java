package com.spdb.study.hrs.hr3.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工实体类
 * @author Mr.Longyx
 * @date 2020年07月20日 21:48
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 8543341888641076341L;

    private int employeeId;
    private String employeeName;
    private String gender;
    private String degree;
    private Date birthday;
    private String telephone;
    private String address;
    /**
     * 职务
     * @author Mr.Longyx
     * @date 2020/7/22 11:20
     */
    private String position;
    /**
     * 所属分公司
     * @author Mr.Longyx
     * @date 2020/7/22 11:19
     */
    private String division;
    /**
     * 入职日期
     * @author Mr.Longyx
     * @date 2020/7/22 11:20
     */
    private Date dateJoined;

    /**
     * 所属部门
     * @author Mr.Longyx
     * @date 2020/7/24 0:36
     */
    private Department department;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

}
