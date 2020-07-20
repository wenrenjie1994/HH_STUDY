package pojo;

/**
 * User: Alex FAN
 * Date: 2020/7/20
 * Time: 17:27
 * Description:简历
 */
public class Resume {

    /**
    * 姓名
    */
    private String name;
    /**
    * 身份证
    */
    private String id;
    /**
    * 学校
    */
    private String school;
    /**
     * 简历情况
     * 0 申请中
     * 1 简历通过
     * 2 笔试通过
     * 3 面试通过
     * 4 签约
     * 5 入职
     */
    private int flag;

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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
