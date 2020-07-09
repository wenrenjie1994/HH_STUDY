package entity;

public class Student {
    int stuNo;
    String name;
    String school;
    String position;


    public Student(){

    }
    public Student(String name, String school,String position) {
        this.stuNo ++;
        this.name = name;
        this.school = school;
        this.position = position;
    }
    public Student(int stuNo,String name, String school,String position){
        this.stuNo = stuNo;
        this.name = name;
        this.school = school;
        this.position = position;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
