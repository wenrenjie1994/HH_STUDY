package com.spdb.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * @create 2019-10-12 9:40
 **/
public class JsonUtils {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T objToBean(Object object,Class<T> beanType){
        try {
            T t = MAPPER.convertValue(object,beanType);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将object结果集转化为泛型类
     * @param object
     * @param typeReference
     * @param <T>
     * @return
     */
    public static <T> T objToTypeReference(Object object, TypeReference<?> typeReference){
        try {
            T t = MAPPER.convertValue(object, typeReference);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为泛型类
     *
     * @param jsonData json数据
     * @param typeReference 对象中的object类型
     * @return
     */
    public static <T> T jsonToTypeReference(String jsonData, TypeReference<?> typeReference) {
        try {
            T t = MAPPER.readValue(jsonData, typeReference);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json字符串转换成map对象。
     * @param json
     * @return
     */
    public static Map jsonToMap(String json) {
        try {
            Map map = MAPPER.readValue(json, Map.class);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将对象转换成json字符串。
     * <p>Title: pojoToJson</p>
     * <p>Description: </p>
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
    	try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * 将json结果集转化为对象
     * 
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将json数据转换成pojo对象list
     * <p>Title: jsonToList</p>
     * <p>Description: </p>
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	try {
    		List<T> list = MAPPER.readValue(jsonData, javaType);
    		return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }

}
