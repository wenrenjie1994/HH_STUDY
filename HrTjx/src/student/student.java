package student;

public class student {
    //    self.name = name
    //    self.IDcard = IDcard
    public String name;
    public String phoneNumber;
    public String age;
    public String degree;
    public String school;
    public String job;
    public String salary;
    public boolean isDelete = false;
    public String gender;
    public String birthday;
    private String IDcard;

    public student() {
        /*方法的重载*/
    }

    public student(String name, String IDcard, String phoneNumber,
                   String gender, String birthday, String age, String degree,
                   String school, String job, String salary) {
        /*idea不太会设置方法注释
         * 构造方法有些类似于Python的init函数*/
        this.name = name;
        this.name = name;
        this.IDcard = IDcard;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.degree = degree;
        this.school = school;
        this.job = job;
        this.salary = salary;


    }


    public void select() {
        System.out.println(this.name + " " + this.IDcard + " " + this.phoneNumber + " " +
                this.gender + " " + this.birthday + " " + this.age + " " + this.degree + " " + this.school);
        System.out.println("应聘工作: " + this.job + " 期望薪资: " + this.salary);
    }

    public String getIDcard() {
        return IDcard;
    }

    public void setIDcard(String IDcard) {
        this.IDcard = IDcard;
    }

}
