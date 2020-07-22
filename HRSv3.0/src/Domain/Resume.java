package Domain;
/*

   用来封装简历信息的javabean

 */
public class Resume {
    private int serialid;
    private String id;
    private String name;
    private String school;
    private String email;

    @Override
    public String toString() {
        return "Resume{" +
                "serialid=" + serialid +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public Resume(int serialid, String id, String name, String school, String email) {
        this.serialid = serialid;
        this.id = id;
        this.name = name;
        this.school = school;
        this.email = email;
    }
    public Resume(){}
    public Resume(String id, String name, String school, String email) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.email = email;
    }

    public int getSerialid() {
        return serialid;
    }

    public void setSerialid(int serialid) {
        this.serialid = serialid;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
