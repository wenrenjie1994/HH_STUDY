package com.spdb.study.hrs.hr4.dataobject;

import java.io.Serializable;

/**
 * 绩效实体类
 * @author Mr.Longyx
 * @date 2020年07月20日 22:18
 */
public class Performance implements Serializable {
    private static final long serialVersionUID = 4972048507216368709L;

    private int employeeId;
    private int examineTypeId;
    /**
     * 评估指标
     * @author Mr.Longyx
     */
    private String evaluationItems;
    /**
     * 绩效成绩
     * @author Mr.Longyx
     * @date 2020/7/22 11:24
     */
    private float grade;

    /**
     * 等级评定
     * @author Mr.Longyx
     * @date 2020/7/22 11:24
     */
    private String ratings;

    private Employee employee;

    private ExamineType examineType;

    public ExamineType getExamineType() {
        return examineType;
    }

    public void setExamineType(ExamineType examineType) {
        this.examineType = examineType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getExamineTypeId() {
        return examineTypeId;
    }

    public void setExamineTypeId(int examineTypeId) {
        this.examineTypeId = examineTypeId;
    }

    public String getEvaluationItems() {
        return evaluationItems;
    }

    public void setEvaluationItems(String evaluationItems) {
        this.evaluationItems = evaluationItems;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
}
