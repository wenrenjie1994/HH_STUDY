package bean;

public class Resume {

    //姓名
    private String name;

    //年龄
    private int age;

    //身份证号
    private String idCard;

    //毕业院校
    private String school;

    /*
     * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     */
    private int processState;

    //离职状态 1表示已离职 0表示未离职
    private int deleteStatus;

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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getProcessState() {
        return processState;
    }

    public void setProcessState(int processState) {
        this.processState = processState;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Resume(String name,int age,String idCard,String school,int processState,int deleteStatus){
        this.name= name;
        this.age= age;
        this.idCard=idCard;
        this.school=school;
        this.processState=processState;
        this.deleteStatus=deleteStatus;

    }
}
