package com.spdb.study.design.pattern.singleton.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 枚举式单例
 * <<Effective Java>> 推荐使用枚举实现单例
 * @author Mr.Longyx
 * @date 2020年06月23日 0:07
 */
public enum  EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    /**
     * 访问点
     * @author Mr.Longyx
     * @date 2020/6/23 0:12
     * @return com.spdb.study.design.pattern.singleton.register.EnumSingleton
     */
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    /**
     *  测试枚举解决单例序列化被破坏问题
     * @author Mr.Longyx
     * @date 2020/6/23 14:49
     */
    public static void main(String[] args) {
//        for(int i=0;i<100;i++){
//            new Thread(()->{
//                System.out.println(EnumSingleton.getInstance().hashCode());
//            }).start();
//        }

        EnumSingleton s1 = null;
        EnumSingleton s2 = EnumSingleton.getInstance();

        FileOutputStream fos = null;

        try{
            //将s2对象写入文件中
            fos = new FileOutputStream("EnumSingleton.obj");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.flush();
            oos.close();

            //将s2还原为s1
            FileInputStream fis = new FileInputStream("EnumSingleton.obj");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (EnumSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s1 == s2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
