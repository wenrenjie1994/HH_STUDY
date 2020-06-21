package com.spdb.study.design.pattern.factory.simplefactory.course;

/**
 * @author Mr.Longyx
 * @date 2020年06月21日 13:51
 */
public class CourseFactory {
    /**
     * 待优化
     * @author Mr.Longyx
     * @date 2020/6/21 13:58
     * @param className
     * @return com.spdb.study.design.pattern.factory.simpleFasctory.ICourse
     */
//    public ICourse choice(String name) {
//        if ("java".equals(name)){
//            return new JavaCourse();
//        }
//        return null;
//    }

    /**
     * 使用反射根据className创建出类(还可进一步优化 调用时存在乱传参数的可能)
     * @author Mr.Longyx
     * @date 2020/6/21 14:02
     * @param className
     * @return com.spdb.study.design.pattern.factory.simpleFasctory.ICourse
     */

//    public ICourse choice(String className){
//        try {
//            if (!(null == className || "".equals(className))){
//                return (ICourse)Class.forName(className).newInstance();
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }

    /**
     * 使用 Class的方式
     * @author Mr.Longyx
     * @date 2020/6/21 14:16
     */

    public ICourse choice(Class<?> clazz) {
        try {
            if (null != clazz) {
                return (ICourse) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
