package com.spdb.study.design.pattern.proxy.dbroute.db;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 20:55
 */
public class DynamicDataSource {
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    private static final String DEFAULT_SOURCE=null;
    /**
     * 构造方法私有化
     * @author Mr.Longyx
     * @date 2020/6/26 20:57
     */
    private DynamicDataSource(){}

    public static String get(){
        /**
         * 线程内单例
         * @author Mr.Longyx
         * @date 2020/6/26 20:57
         * @return java.lang.String
         */
        return local.get();
    }

    public static void restore(){
        local.set(DEFAULT_SOURCE);
    }

    /**
     * DB2019 DB2020
     * @author Mr.Longyx
     * @date 2020/6/26 20:59
     * @param source
     */
    public static void set(String source){
        local.set(source);
    }

    public static void set(int year){
        local.set("DB_"+year);
    }
}