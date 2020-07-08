package com.ram.utils;

public class Candidate {

    private String Name;
    private String Age;
    private String Education;
    private String Gender;

    public String getName() {
        return Name;
    }

    public String getAge() {
        return Age;
    }

    public String getEducation() {
        return Education;
    }

    public String getGender() {
        return Gender;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public void setEducation(String Education) {
        this.Education = Education;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Candidate(String Name, String Age, String Education, String Gender) {
        this.Name = Name;
        this.Age = Age;
        this.Education = Education;
        this.Gender = Gender;
    }


}
