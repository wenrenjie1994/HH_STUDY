package com.cuit.util;


import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ：liwenyi
 * @date ：Created in 2019/10/29 20:48
 * @description：检测数据类型是否为空的工具类
 * @modified By：
 */
public class ObjTool {
    /**
     * @return boolean
     * @Description:判断字符串是否为空
     * @author liwenyi
     * @date 2013-11-21 上午11:27:14
     */
    public static boolean isNotNull(String str) {
        boolean flag = true;
        if (null == str || "".equals(str.trim())
                || "null".equalsIgnoreCase(str.trim())) {
            flag = false;
        }
        return flag;

    }

    /**
     * @return boolean
     * @Description:判断字符串数组是否为空
     * @date 2013-11-21 上午11:28:07
     */
    public static boolean isNotNull(String[] strArray) {
        boolean flag = true;
        if (null == strArray || strArray.length == 0) {
            flag = false;
        }
        return flag;

    }

    /**
     * @return boolean
     * @Description:List是否为空
     * @date 2013-11-21 上午11:28:50
     */
    public static boolean isNotNull(List list) {
        boolean flag = true;
        if (null == list || 0 == list.size()) {
            flag = false;
        }
        return flag;
    }

    /**
     * @return boolean
     * @Description:List为空
     * @date 2013-11-21 上午11:28:50
     */
    public static boolean isNull(List list) {
        boolean flag = true;
        if (null != list && 0 < list.size()) {
            flag = false;
        }
        return flag;
    }

    /**
     * @return boolean
     * @Description:List是否为空
     * @date 2013-11-21 上午11:28:50
     */
    public static boolean isNotNull(Set set) {
        boolean flag = true;
        if (null == set || 0 == set.size()) {
            flag = false;
        }
        return flag;
    }

    /**
     * @return boolean
     * @Description: Map是否为空
     * @date 2013-11-21 上午11:29:52
     */
    public static boolean isNotNull(Map map) {
        boolean flag = true;
        if (null == map || 0 == map.size()) {
            flag = false;
        }
        return flag;
    }

    /**
     * @return boolean
     * @Description:对象数组是否为空
     * @date 2013-11-21 上午11:29:19
     */
    public static boolean isNotNull(Object... obj) {
        boolean flag = true;
        if (null == obj || 0 == obj.length || null == obj[0]) {
            flag = false;
        }
        return flag;
    }

    /**
     * @return boolean
     * @Description:对象是否为空
     * @date 2013-11-21 上午11:29:19
     */
    public static boolean isNotNull(Object obj) {
        boolean flag = true;
        if (null == obj) {
            flag = false;
        }
        return flag;
    }

    public static String getNotNullStr(String str) {

        if (str == null) {
            return "";
        }

        return str;
    }

}