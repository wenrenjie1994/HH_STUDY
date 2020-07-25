package operate;

/**
 * 简历类
 * @author 张馨悦
 *
 */
public class Resume {

	//姓名
    private String name;
    //身份证号
    private String id;
    //学历
    private String education;
    //电话号
    private String telephone;
    /**
     * 简历状态
     * -1：加入人才库
     * 0：已申请
     * 1：简历通过
     * 2：笔试通过
     * 3：面试通过
     * 4：体检通过
     * 5：背调通过
     * 6：已签约
     * 7：已入职
     */
    private int process;

    public Resume(String name, String id, String education, String telephone ,int process) {
        this.name = name;
        this.id = id;
        this.education = education;
        this.telephone = telephone;
        this.process = process;
    }

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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }


    @Override
    public String toString() {
        return "姓名：" + name + '\n' +
                "身份证号：" + id + '\n' +
                "学历：" + education + '\n' +
                "电话号：" + telephone + '\n' +
                "简历状态：" + process;
    }
}
