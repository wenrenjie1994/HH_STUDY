package helloworld.lowbHrSystem1;

public class Person {
    private String name;
    private int id;
    private String school;
    private int process;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }


    public Person(String name, int id, String school, int process) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = process;

    }

    public Person() {
    }
}
