package model;

/**
 * @Author: chenlei
 * @Date: 2020/7/15 14:29
 */
public class Resume {
    private String name;
    private Integer year;
    private String job;


    public Resume(String name, Integer year, String job) {
        this.name = name;
        this.year = year;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Resume:" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", job='" + job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
