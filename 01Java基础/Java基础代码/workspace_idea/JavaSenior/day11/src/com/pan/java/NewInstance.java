package com.pan.java;

import org.junit.Test;

import java.util.Random;

/**通过反射创建对应的运行时类的对象
 * @author zhaopan@163.com
 * @creat 2020-04-27 15:15
 */
public class NewInstance {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class clazz = Person.class;
        /*
        newInstance():调用此方法创建对应的运行时类的对象
        要想此方法正常的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器访问权限得够，通常设置为public。

        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有次构造器
         */
        Person obj = (Person) clazz.newInstance();
        System.out.println(obj);
    }

    //体会反射的动态性（运行时才知道new的谁的对象）
    @Test
    public void test2(){
        for (int i = 0; i < 100; i++) {
            int num = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch(num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.pan.java.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建一个指定类的对象
     * @param classPath 指定类的全类名
     * @return
     * @throws Exception
     */
    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
