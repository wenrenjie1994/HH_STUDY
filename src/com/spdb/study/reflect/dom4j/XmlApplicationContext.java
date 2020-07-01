package com.spdb.study.reflect.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * dom4j解析xml文件
 * 模拟Spring 通过反射创建对象
 * @author Mr.Longyx
 * @date 2020年06月22日 0:37
 */
public class XmlApplicationContext {
    /**
     * 缓存Spring容器中的Bean对象
     * @author Mr.Longyx
     * @date 2020/6/22 0:46
     */
    private  Map<String, Object> beans = new HashMap<String, Object> ();

    /**
     * 利用配置文件初始化当前容器
     * 利用xml配置文件，初始化全部的Bean对象
     * @author Mr.Longyx
     * @date 2020/6/22 0:40
     * @param xml
     */
    public XmlApplicationContext(String xml) {
        InputStream in = null;
        try {
            /**
             * 利用Dom4j，读取XML文件
             * @author Mr.Longyx
             * @date 2020/6/22 0:42
             */
            in = getClass().getClassLoader().getResourceAsStream(xml);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(in);

            /**
             * 解析xml
             * @author Mr.Longyx
             * @date 2020/6/22 0:52
             * @param xml
             */
            Element root = doc.getRootElement();
            List<Element> list = root.elements("bean");
            for (Element element : list) {
                /**
                 * 解析XML文件内容，得到Bean类名 和 bean的id
                 * @author Mr.Longyx
                 * @date 2020/6/22 0:43
                 * @param xml
                 */
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");

                /**
                 * 动态加载类 动态创建对象
                 * @author Mr.Longyx
                 * @date 2020/6/22 0:54
                 * @param xml
                 */
                Class<?> clazz = Class.forName(className);
                Object bean = clazz.newInstance();

                /**
                 * 将对象和对应的id添加到map中进行缓存
                 * @author Mr.Longyx
                 * @date 2020/6/22 0:45
                 * @param xml
                 */
                beans.put(id,bean);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null != in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Object getBean(String id){
        return beans.get(id);
    }

    /**
     * 此处泛型方法，优点是可以减少一次类型转换
     * @author Mr.Longyx
     * @date 2020/6/22 1:48
     * @param id
     * @param clazz
     * @return T
     */
    public <T> T getBean(String id, Class<?> clazz){
        return (T)beans.get(id);
    }
}
