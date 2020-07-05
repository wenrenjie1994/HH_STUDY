package bean;

/**
 * @program: HR_SYS_1.0（基于内存和控制台）
 * @className: Resume
 * @description: 简历信息
 * @author: 何文艺
 * @creat: 2020/7/4 10:14
 **/
public class Resume {

    /*
    姓名
     */
    private String name;
    /*
    身份证号
     */
    private String id;
    /*
    学校
     */
    private String school;
    /*
    简历状态
    0:已申请
    1：简历通过
    2：笔试通过
    3：体检通过
    4：背调通过
    5：已签约
    6：已入职
     */
    private int process;
    /*
    逻辑删除
    0:不显示
    1:显示
     */
    private int deleteStatus;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getProcess() {
        return this.process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public int getDeleteStatus() {
        return this.deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Resume(String name, String id, String school) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = 0;
        this.deleteStatus = 1;
    }
}
