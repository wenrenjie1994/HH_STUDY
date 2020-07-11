package bean;

/**
 * @author 熊彩铃
 * @program HR_Version3数据库版招聘系统
 * @description 招聘信息
 * @date 2020/7/11 12:29
 */
public class Resume {
    /**
     * 姓名
     * */
    private String name;
    /**
     * 身份证号码
     * */
    private String ID_Number;
    /**
     * 学校
     * */
    private String school;
    /**
     * 年龄
     * */
    private Integer age;

    public String getName() {
        return name;
    }

    public String getID_Number() {
        return ID_Number;
    }

    public String getSchool() {
        return school;
    }

    public Integer getAge() {
        return age;
    }

    public Resume(String name, String ID_Number, String school, Integer age) {
        this.name = name;
        this.ID_Number = ID_Number;
        this.school = school;
        this.age = age;
    }
}
