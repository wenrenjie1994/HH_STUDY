package com.spdb.study.design.principle.dependencyinversion;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 12:39
 */
public class Longyx {
    /**
     * 需改进的实现
     * @author Mr.Longyx
     * @date 2020/6/17 12:47
     *
     * public void studyJavaCourse(){
     *         System.out.println("龙远栩正在学习Java课程");
     *     }
     *     public void studyPythonCourse(){
     *         System.out.println("龙远栩正在学习Python课程");
     *     }
     *
     *     public void studyAICourse(){
     *         System.out.println("龙远栩正在学习AI课程");
     *     }
     */
//    public void study(ICourse item){
//        item.study();
//    }

    private ICourse iCourse;

//    public Longyx(ICourse iCourse){
//        this.iCourse = iCourse;
//    }

    public void study(){
        iCourse.study();
    }

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }
}
