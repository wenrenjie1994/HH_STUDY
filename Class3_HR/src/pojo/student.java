package pojo;

public class student {
    private String studentName;

    private String studentClass;

    private int studentId;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public  student(String studentName,String studentClass,int studentId){
        this.studentName=studentName;
        this.studentClass=studentClass;
        this.studentId=studentId;
    }
}
