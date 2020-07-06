package model;

/**
 * @program: HR_SYS_2.0（基于txt文件）
 * @className: Resume
 * @description: 简历信息
 * @author: 何文艺
 * @creat: 2020/7/6 16:01
 **/
public class Resume {
    /*
    姓名
     */
    public String name;
    /*
    身份证号
     */
    public String id;
    /*
    学校
     */
    public String school;
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
    public int process;
    /*
    逻辑删除
    0:不显示
    1:显示
     */
    public int deleteStatus;

    public Resume(String name, String id, String school) {
        this.name = name;
        this.id = id;
        this.school = school;
        this.process = 0;
        this.deleteStatus = 1;
    }
}
