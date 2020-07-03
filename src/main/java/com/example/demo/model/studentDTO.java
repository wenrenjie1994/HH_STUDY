package com.example.demo.model;

public class studentDTO {
    private Integer studentId;
    private String studentName;
    private String studentTel;
    private String studentBirth;
    private String studentAddress;
    private String studentNumber;
    private String studentEmail;
    private String studentSchool;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentTel() {
        return studentTel;
    }

    public void setStudentTel(String studentTel) {
        this.studentTel = studentTel;
    }

    public String getStudentBirth() {
        return studentBirth;
    }

    public void setStudentBirth(String studentBirth) {
        this.studentBirth = studentBirth;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }

    @Override
    public String toString() {
        return "studentDTO{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentTel='" + studentTel + '\'' +
                ", studentBirth='" + studentBirth + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentSchool='" + studentSchool + '\'' +
                '}';
    }
}
