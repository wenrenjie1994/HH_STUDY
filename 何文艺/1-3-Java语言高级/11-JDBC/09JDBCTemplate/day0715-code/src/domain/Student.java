package domain;

/**
 * @program: TODO
 * @className: Student
 * @description: TODO
 * @author: 何文艺
 * @creat: 2020/7/8 10:23
 **/
public class Student {
    private Integer id;//解决Failed to convert property value of type 'null' to required type 'double' for property 'math';类似问题
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private Double math;
    private Double english;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getEnglish() {
        return english;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String sex, String address, Double math, Double english) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.math = math;
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                " id:" + id +
                " name:" + name +
                " age:" + age +
                " sex:" + sex +
                " address:" + address +
                " math:" + math +
                " english:" + english +
                " }";
    }
}
