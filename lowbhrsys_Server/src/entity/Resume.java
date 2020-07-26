package entity;

public class Resume {
    int id;
    String name;
    String school;
    String position;
    String oldName;

    public Resume() {

    }

    public Resume(String name, String school, String position) {
        this.name = name;
        this.school = school;
        this.position = position;
    }

    public Resume(int id, String name, String school, String position) {
        this.id = id;
        this.name = name;
        this.school = school;
        this.position = position;
    }

    public Resume(String oldName,String name, String school, String position) {
        this.name = name;
        this.school = school;
        this.position = position;
        this.oldName = oldName;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", school='" + school + '\'' +
                        ", position='" + position + '\'';
    }
}
