package bean;

/**
 * @program: HR_SYS
 * @description: 简历信息
 * @author: 文仁杰
 * @create: 2020-06-30 17:59
 **/
public class Resume {

    /**
     *姓名
     */
    private String name;
    /**
     *身份证号
     */
    private String id;
    /**
     *学校
     */
    private String school;
    /**
     *
     * * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：体检通过
     * 4：背调通过
     * 5：已签约
     * 6：已入职
     */
    private int process;

    /**
    *逻辑删除
     * 0 : bu zhanshi
     * 1  展示
    */
    private int deleteStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Resume(String name, String id) {
        this.name = name;
        this.id = id;
        this.process=0;
        this.deleteStatus=0;
    }
}
