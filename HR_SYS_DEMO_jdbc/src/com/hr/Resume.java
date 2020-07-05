package com.hr;

import java.io.Serializable;

public class Resume implements Serializable {
    private Integer id;
    private String name;
    private String school;
    private String status;
    public Resume(String stdName, String stdSchool, String stdStatus){
        this.name = stdName;
        this.status = stdStatus;
        this.school = stdSchool;
    }
    public int getId(){ return this.id; }
    public String getName(){
        return this.name;
    }
    public String getSchool(){
        return this.school;
    }
    public String getStatus(){return this.status;}
    public void setName(String stdName){this.name = stdName;}
    public void setId(Integer stdId){this.id = stdId;}
    public void setSchool(String stdSchool){this.school = stdSchool;}
    public void setStatus(String stdStatus){this.status = stdStatus;}
}
