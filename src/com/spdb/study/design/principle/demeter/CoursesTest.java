package com.spdb.study.design.principle.demeter;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 15:44
 */
public class CoursesTest {
    public static void main(String[] args) {
        TeamLeader leader = new TeamLeader();
        Employee employee = new Employee();
        leader.checkNumber(employee);
    }
}
