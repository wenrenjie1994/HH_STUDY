package com.spdb.study.design.principle.dependencyinversion;

/**
 *依赖倒置原则：高层模块不应该依赖于低层模块，二者都应该依赖其抽象
 * 抽象不应该依赖细节，细节应该依赖抽象  面向接口编程
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
