package bean;

/**
 * @Author lee
 * @Date 2020/7/13 11:28 PM
 * bean：
 * 1、所有属性为private
 * 2、提供默认构造方法
 * 3、提供getter和setter
 * 4、实现serializable接口
 **/


public class Resume {
    // 姓名
    private String name;

    // 身份证号码
    private String id;

    // 学校
    private String school;

    /**
     * age/gender/phone/e-mail...
     */

    /**
     * 0 尚未申请
     * 1 简历通过
     * 2 笔试通过
     * 3 体检通过
     * 4 背调通过
     * 5 已签约
     * 6 已入职
     */
    private int process;


    /**
     * logical delete
     * 0 non-display
     * 1 display
     */
    private int deleteStatus;
    // TODO what's the meaning?

    // 私有变量，通过get方法获取、set方法设置
    // 直接右键generate getter() and setter()
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

    // 构造函数，初始化
    public Resume(String name, String id, String school) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = 0;
        this.deleteStatus = 0;
    }

}
