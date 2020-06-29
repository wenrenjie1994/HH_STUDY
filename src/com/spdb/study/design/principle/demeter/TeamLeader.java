package com.spdb.study.design.principle.demeter;


/**
 * @author Mr.Longyx
 * @date 2020年06月17日 15:37
 */
public class TeamLeader {
    public void checkNumber(Employee employee){
        /**
         * Leader不需要和Course直接打交道，与Course打交道的是员工
         * @author Mr.Longyx
         * @date 2020/6/17 16:08
         * @param employee
         * List<Course> courses = new ArrayList<> ();
         * for (int i=0; i<200; i++){
         *     courses.add(new Course());
         * }
         */
        employee.checkNumberOfCourses();
    }
}
