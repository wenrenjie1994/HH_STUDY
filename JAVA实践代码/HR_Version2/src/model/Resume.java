package model;

/**
 * @author 熊彩铃
 * @program HR_Version2文本储蓄版招聘系统
 * @description 招聘信息
 * @date 2020/7/6 0:14
 */
public class Resume {
    /**
     * 姓名
     * */
    private String name;
    /**
     * 身份证号码
     * */
    private String ID_number;
    /**
     * 学校
     * */
    private String school;
    /**
     * 年龄
     * */
    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getID_number() {
        return ID_number;
    }

    public String getSchool() {
        return school;
    }

    public Integer getAge() {
        return age;
    }

    public Resume(String name, String ID_number, String school, Integer age) {
        this.name = name;
        this.ID_number = ID_number;
        this.school = school;
        this.age = age;
    }
}
