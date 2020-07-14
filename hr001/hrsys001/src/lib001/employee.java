package lib001;

/**
 * @program: hr001
 * @description: 员工类
 * @author: Victor(LAI Wentao)
 * @create: 2020-07-10 20:57
 */
public class employee {
    private String name;
    private String age;
    private String sex;
    private String home;
    private String entry;
    public employee(String name,String age,String sex,String home,String entry){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.home =home;
        this.entry = entry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }


}


