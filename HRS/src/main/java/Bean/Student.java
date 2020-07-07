package Bean;

/**
 * @author：ljj0452@gmail.com
 * @time: 2020/7/4 22:10
 */
public class Student {
    private String stuID;
    private String name;
    private int age;
    private String major;
    private int interviewScore;

    public Student() {
    }

    public Student(String stuID, String name, int age, String major, int interviewScore) {
        this.stuID = stuID;
        this.name = name;
        this.age = age;
        this.major = major;
        this.interviewScore = interviewScore;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getInterviewScore() {
        return interviewScore;
    }

    public void setInterviewScore(int interviewScore) {
        this.interviewScore = interviewScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuID='" + stuID + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", major='" + major + '\'' +
                ", interviewScore=" + interviewScore +
                '}';
    }
}
