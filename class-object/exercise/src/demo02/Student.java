package demo02;
/*
对于基本类型中的布尔类型 get要写成isXXX
*/

public class Student {
    private String name;
    private int age;
    private boolean male;
    public void setMale(boolean b){
        male =b;
    }
    public boolean isMale(){
        return male;
    }
    public void setName(String str){
        name =str;
    }
    public String getName(){
        return name;
    }
    public void setAge(int num){
        if(num>=0&&num<100){
            age=num;
        }else{
            System.out.println("数据不合理");
        }
    }
    public int getAge(){
        return age;
    }
}
