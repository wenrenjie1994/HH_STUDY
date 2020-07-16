package model;

public class Interviewee {
    private String name;
    private int age;
    private String school;
    private String ID;
    private String position;

    public Interviewee(String name, int age, String school, String ID, String position) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.ID = ID;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Interviewee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", ID='" + ID + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
