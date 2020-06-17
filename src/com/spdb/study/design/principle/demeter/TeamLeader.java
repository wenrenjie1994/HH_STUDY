package com.spdb.study.design.principle.demeter;
import	java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 15:37
 */
public class TeamLeader {
    public void checkNumber(Employee employee){
        employee.checkNumberOfCourses();
    }
}
