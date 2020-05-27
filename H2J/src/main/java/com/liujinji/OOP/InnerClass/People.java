package com.liujinji.OOP.InnerClass;

public class People {
    private String name = "kevin";
    static String workNumber ="20000";
    // 内部类
    public class Student {
        String studentID = "10000";
        public String getStudentInfo() {
            // 内部类获取外部类成员变量可以直接得到
            return "Name: " + name + "\nStudentID: " + studentID;
        }
    }

    // 静态内部类
    public static class teacher{
        String workNumber ="30000";
        public String getTeacherName(){
            //静态内部类获取外部非静态成员可以使用 new 外部类().成员方式获得
            return "Name: "+new People().name;
        }
        public String getWorkNumber(){
            // 静态内部类获得外部类静态成员可以使用 外部类名.外部静态成员
            return "WorkNumber: "+People.workNumber;
        }
        public int getTeacherAge(){
            // 局部内部类，只在当前方法作用域有效
            class Teacher{
                private Integer age;
                public Teacher(int age){
                    this.age=age;
                }
                public void setAge(Integer age) {
                    this.age = age;
                }

                public int getAge() {
                    return this.age;
                }
            }
            Teacher english = new Teacher(10);
            return english.getAge();
        }
    }

    // 匿名内部类, 当需要传参时，内部使用到的参数必须使用final修饰，没有使用的可以不加
    // 匿名内部类必须继承一个父类或者实现一个接口
    public IManager getManager(final String name,String sex){
        return new IManager(){
            public String getName(){
                return name;
            }
        };
    }
}