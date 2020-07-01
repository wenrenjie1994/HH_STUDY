package com.spdb.study.design.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Longyx
 * @date 2020年06月28日 15:49
 */
public class Leader {
    private Map<String,Employee> register = new HashMap<>();

    public Leader(){
        register.put("通讯",new EmployeeA());
        register.put("架构",new EmployeeB());
    }
    /**
     * Leader需要预先知道每个员工的特长和特征，进行任务分发
     * @author Mr.Longyx
     * @date 2020/6/28 15:52
     * @param task
     */
    public void doSomething(String task){
        register.get(task).done(task);
    }
}
