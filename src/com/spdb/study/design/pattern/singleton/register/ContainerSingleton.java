package com.spdb.study.design.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例
 * @author Mr.Longyx
 * @date 2020年06月23日 15:10
 */
public class ContainerSingleton {
    private static Map<String, Object> ioc = new ConcurrentHashMap<>();
    /**
     * 构造方法私有化
     * @author Mr.Longyx
     * @date 2020/6/23 15:10
     */
    private ContainerSingleton(){}

    /**
     * 全局访问入口
     * synchronized 解决线程安全问题
     * @author Mr.Longyx
     * @date 2020/6/23 15:10
     */
    public static Object getBean(String className){
        synchronized (ioc) {
            if (!ioc.containsKey(className)){
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }
            return ioc.get(className);
        }
    }

}
