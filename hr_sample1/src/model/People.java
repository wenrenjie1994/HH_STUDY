package model;

public class People {
     private String name;
     private String id;
     private int school;
     public String getName()
     {
         return name;
     }
     public String getID()
     {
         return id;
     }
     public int getSchool()
     {
         return school;
     }
     public void setName(String name)
     {
         this.name=name;
     }
    public void setID(String id)
    {
        this.id=id;
    }
    public void setSchool(int school)
    {
        this.school=school;
    }
    public People(String name,String id)
    {
        this.name=name;
        this.id=id;
        this.school=0;
    }
    public People(String name,String id,int school)
    {
        this.name=name;
        this.id=id;
        this.school=school;
    }
}
