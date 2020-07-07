package student;

public class student {
    //    self.name = name
    //    self.IDcard = IDcard
    public String name;

    public String IDcard;
    public String phoneNumber;
    public String gender;
    public String birthday;
    public int age;
    public String degree;
    public String school;
    public String job;
    public String salary;
    public boolean isDelete;

//    print(self.name,self.IDcard,self.phoneNumber,self.gender,
//          self.birthday,self.age,self.degree,self.school)
//    print("应聘工作",self.job,"期望薪资",self.salary)
    public void select(){
        System.out.println(this.name+" "+this.IDcard+" "+this.phoneNumber+" "+
                this.gender+" "+this.birthday+" "+this.age+" "+this.degree+" "+this.school);
        System.out.println("应聘工作: "+this.job+" 期望薪资: "+this.salary);
    }
}
