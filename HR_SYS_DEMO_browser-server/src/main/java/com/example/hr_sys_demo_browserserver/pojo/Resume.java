package com.example.hr_sys_demo_browserserver.pojo;

import java.io.Serializable;

public class Resume{
    private Integer id;
    private String name;
    private String school;
    /**
     *
     * * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     * 7: 简历已失效
     */
    private String status;

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
