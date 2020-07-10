package com.pan.java2;

import com.pan.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 获取当前运行时类的属性结构
 *
 * @author zhaopan@163.com
 * @creat 2020-04-28 13:19
 */
public class FieldTest {

    @Test
    public void test1() {
        Class clazz = Person.class;
        //获取属性结构
        //getFields():
        Field[] fields = clazz.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

    }

}
