package com.spdb.study.design.pattern.builder.sql;

import java.io.Serializable;

/**
 * SQL排序组件
 * @author Mr.Longyx
 * @date 2020年07月05日 12:09
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 7954548792613891229L;

    /**
     * 指明升序还是降序
     * @author Mr.Longyx
     * @date 2020/7/5 13:09
     */
    private boolean ascending;
    /**
     * 指明升序或降序的字段名称
     * @author Mr.Longyx
     * @date 2020/7/5 13:10
     */
    private String propertyName;

    @Override
    public String toString(){
        return propertyName + ' ' + (ascending ? "asc" : "desc");
    }

    protected Order(String propertyName, boolean ascending){
        this.propertyName = propertyName;
        this.ascending = ascending;
    }

    /**
     * 升序排序
     * @author Mr.Longyx
     * @date 2020/7/5 13:14
     */
    public static Order asc(String propertyName){
        return new Order(propertyName, true);
    }

    /**
     * 降序排序
     * @author Mr.Longyx
     * @date 2020/7/5 13:17
     */
    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }


}
