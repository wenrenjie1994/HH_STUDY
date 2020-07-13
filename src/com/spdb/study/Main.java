package com.spdb.study;

import java.lang.reflect.Field;

/**
 *
 * @author Mr.Longyx
 * @date 2020/6/15 18:57
 */
public class Main {
    public static void main(String[] args) {

    }

    //内部类
    public static class BeanUtils{
        public static Object copy(Object prototype){
            Object returnVal = null;
            /**
             * 获取Class对象
             * @author Mr.Longyx
             * @date 2020/7/13 11:54
             * @param prototype
             * @return java.lang.Object
             */
            try {
                Class<?> clazz = prototype.getClass();
                returnVal = clazz.newInstance();
                /**
                 * 获取该类中所有的字段值
                 * @author Mr.Longyx
                 * @date 2020/7/13 11:55
                 * @param prototype
                 * @return java.lang.Object
                 */
                for (Field field : clazz.getDeclaredFields()) {
                    //开通访问权限
                    field.setAccessible(true);
                    field.set(returnVal, field.get(prototype));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return  returnVal;
        }
    }
}
