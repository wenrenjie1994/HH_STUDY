package com.spdb.study.design.pattern.singleton.serial;

import java.io.*;

/**
 * 序列化单例(饿汉式)
 * @author Mr.Longyx
 * @date 2020年06月23日 14:08
 */
public class SerialSingleton implements Serializable {
    private static final SerialSingleton INSTANCE = new SerialSingleton();
    /**
     * 构造方法私有化
     * @author Mr.Longyx
     * @date 2020/6/23 14:09
     */
    private SerialSingleton(){}

    /**
     * 提供全局访问点
     * @author Mr.Longyx
     * @date 2020/6/23 14:09
     */
    public static SerialSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 重写readResolve方法：不过是覆盖了序列化和反序列化的对象
     * 结果还是创建了两次，只是发生在JVM层面，相对会比较安全
     * 之前反序列化的对象会被GC回收
     * @author Mr.Longyx
     * @date 2020/6/23 14:44
     * @return java.lang.Object
     */
    private  Object readResolve(){
        return INSTANCE;
    }

    /**
     * 模拟序列化破坏单例的场景
     * @author Mr.Longyx
     * @date 2020/6/23 14:26
     */
    public static void main(String[] args) {
        SerialSingleton s1 = null;
        SerialSingleton s2 = SerialSingleton.getInstance();

        FileOutputStream fos = null;

        try{
            //将s2对象写入文件中
            fos = new FileOutputStream("SerialSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            //将s2还原为s1
            FileInputStream fis = new FileInputStream("SerialSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerialSingleton)ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
