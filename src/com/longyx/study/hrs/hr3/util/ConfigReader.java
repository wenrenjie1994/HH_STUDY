package com.longyx.study.hrs.hr3.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * 采用单例模式读取performance.properties配置文件
 * @author Mr.Longyx
 * @date 2020年07月24日 17:29
 */
public class ConfigReader {
    private Properties properties = new Properties();

    private static final ConfigReader INSTANCE;

    static {
        INSTANCE = new ConfigReader();
    }

    private ConfigReader(){
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("main/resources/property/config.properties");
            /**
             * 将输入流放到Properties中
             * @author Mr.Longyx
             * @date 2020/7/24 17:39
             */
            properties.load(resourceAsStream);

        }catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }

    public static ConfigReader getInstance() {
        return INSTANCE;
    }

    /**
     * 根据属性名获取属性值
     * @author Mr.Longyx
     * @date 2020/7/24 17:41
     * @param key
     * @return java.lang.String
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        String driverName = ConfigReader.getInstance().getProperty("driver-name");
        System.out.println(driverName);

        String url = ConfigReader.getInstance().getProperty("url");
        System.out.println(url);
    }

}
