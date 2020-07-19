package resume;

public class Resume {
    private String name;//姓名
    private String id;//身份证
    private String school;//学校
    private int process;//当前状态
    /*
     * 0.申请
     * 1.简历通过
     * 2.笔试通过
     * 3.面试通过
     * 4.体检通过
     * 5.背调通过
     * 6.已签约
     * 7.已入职
     * */
    private int deleteStatus;//删除 0.不展示1.展示

    public Resume(String name, String id, String school, int process, int deleteStatus) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = process;
        this.deleteStatus = deleteStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getSchool() {
        return school;
    }

    public int getProcess() {
        return process;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }
}
