package bean;

public class Person {
    private String name;
    private String age;
    private String sex;
    private String school;


    public Person() {
    }

    public Person(String name, String age, String sex, String school) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.school = school;

    }



    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public String getSex() {
        return sex;
    }

    public String getSchool() {
        return school;
    }



    public void setName(String name) {
        this.name = name;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSchool(String school) {
        this.school = school;
    }


}
