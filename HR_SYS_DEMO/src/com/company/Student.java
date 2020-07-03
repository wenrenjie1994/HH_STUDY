package com.company;

public class Student {
    private String name;
    private String id;
    public Student(String stdName, String stdId){
        this.name = stdName;
        this.id = stdId;
    }
    public String getId(){ return this.id; }
    public String getName(){
        return this.name;
    }
    public void setName(String stdName){this.name = stdName;}
    public void setId(String stdId){this.id = stdId;}
}
