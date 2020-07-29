package model;

public class JobHunter {
    private String Name;
    private String Gender;
    private String Major;
    private String School;
    //private String Age;
    private int Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        this.Major = major;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        this.School = school;
    }

    //    public String getAge() {
//        return Age;
//    }
    public int getAge() {
        return Age;
    }

    //    public void setAge(String age) {
//        this.Age = age;
//    }
    public void setAge(int age) {
        this.Age = age;
    }

    public JobHunter(String name, String gender, String major, String school, int age) {
        this.Name = name;
        this.Gender = gender;
        this.Major = major;
        this.School = school;
        this.Age = age;
    }

    public  JobHunter(){

    }


}