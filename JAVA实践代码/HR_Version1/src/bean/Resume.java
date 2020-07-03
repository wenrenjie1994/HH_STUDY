package bean;

/**
 * @author 熊彩铃
 * @program HRSystem_version1
 * @description 简历信息
 * @date 2020/7/2 15:43
 */
public class Resume {
    /**
     * 姓名
     * */
    private String name;
    /**
     * 学校
     * */
    private String school;
    /**
     * 身份证号码
     * */
    private String ID_number;
    /**
     * 性别
     * */
    private String gender;
    /**
     * 年龄
     * */
    private Integer age;
    /**
     * 应聘状态
     * 0 已申请
     * 1 简历通过
     * 2 笔试通过
     * 3 面试通过
     * 4 体检通过
     * 5 背调通过
     * 6 已签约
     * 7 已入职
     * */
    private Integer status;

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getID_number() {
        return ID_number;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getStatus() {
        return status;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Resume(String name, String school, String ID_number, String gender, Integer age) {
        this.name = name;
        this.school = school;
        this.ID_number = ID_number;
        this.gender = gender;
        this.age = age;
        this.status = 0;
    }
}
