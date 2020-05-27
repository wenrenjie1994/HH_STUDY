package com.liujinji.OOP.InnerClass;

public class People {
    private String name = "kevin";

    public class Student {
        String studentID = "10000";

        public String getStudentInfo() {
            return "Name: " + name + "\nStudentID: " + studentID;
        }
    }
}
