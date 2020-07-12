package model;

/**
 * 面试者
 */
public class Interviewee {
    private String intervieweeName;
    private String intervieweeSex;
    private Integer intervieweeAge;
    private String intervieweeSchool;

    public Interviewee() {
        super();
    }

    public Interviewee(String intervieweeName, String intervieweeSex, Integer intervieweeAge, String intervieweeSchool) {
        this.intervieweeName = intervieweeName;
        this.intervieweeSex = intervieweeSex;
        this.intervieweeAge = intervieweeAge;
        this.intervieweeSchool = intervieweeSchool;
    }

    public String getIntervieweeName() {
        return intervieweeName;
    }

    public void setIntervieweeName(String intervieweeName) {
        this.intervieweeName = intervieweeName;
    }

    public String getIntervieweeSex() {
        return intervieweeSex;
    }

    public void setIntervieweeSex(String intervieweeSex) {
        this.intervieweeSex = intervieweeSex;
    }

    public Integer getIntervieweeAge() {
        return intervieweeAge;
    }

    public void setIntervieweeAge(Integer intervieweeAge) {
        this.intervieweeAge = intervieweeAge;
    }

    public String getIntervieweeSchool() {
        return intervieweeSchool;
    }

    public void setIntervieweeSchool(String intervieweeSchool) {
        this.intervieweeSchool = intervieweeSchool;
    }
}
