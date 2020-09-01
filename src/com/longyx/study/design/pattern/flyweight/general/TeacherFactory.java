package com.spdb.study.design.pattern.flyweight.general;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂
 * @author Mr.Longyx
 * @date 2020年07月05日 23:18
 */
public class TeacherFactory {
    private Map<String,Teacher> pool;

    public TeacherFactory(){
        pool =  new HashMap<>();
    }

    public Teacher getTeacher(String num){
        Teacher teacher = pool.get(num);
        if(!pool.containsKey(num)){
            teacher = new Teacher();
            teacher.setNum(num);
            pool.put(num, teacher);
        }
        return teacher;
    }
}
