package medol;

/**
 * @program: HH_STUDY
 * @description:
 * @author: qiu haoran
 * @create: 2020-07-20 20:45
 */
public class Resume {
    public String resumeName;
    public String resumeId;
    public int resumeSchool;
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
    public int resumeprocess;

    /**
     *逻辑删除
     * 0 : bu zhanshi * 1  展示
     */
    public int deleteStatus;
    public Resume(String resumeName, String resumeId, int resumeSchool,int resumeprocess,int deleteStatus) {
        this.resumeName = resumeName;
        this.resumeId = resumeId;
        this.resumeSchool = resumeSchool;
        this.resumeprocess = resumeprocess;
        this.deleteStatus = deleteStatus;
    }
}