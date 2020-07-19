package Resume;

public class StudentInformation {
    private int id;
    private String name;
    private String school;
    private String email;

    public StudentInformation(int id, String name, String school, String email) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
