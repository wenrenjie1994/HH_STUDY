package com.hr;

import java.io.Serializable;

public class Resume implements Serializable {
    private String name;
    private String id;
    private String school;
    public Resume(String stdName, String stdId, String stdSchool){
        this.name = stdName;
        this.id = stdId;
        this.school = stdSchool;
    }
    public String getId(){ return this.id; }
    public String getName(){
        return this.name;
    }
    public String getSchool(){
        return this.school;
    }
    public void setName(String stdName){this.name = stdName;}
    public void setId(String stdId){this.id = stdId;}
    public void setSchool(String stdSchool){this.school = stdSchool;}
}
