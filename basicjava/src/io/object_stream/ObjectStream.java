package io.object_stream;

//准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组
//
//        然后把该数组序列化到一个文件heros.lol
//
//        接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样

import java.io.*;

public class ObjectStream {
    public static void main(String[] args) {
        Hero[] heroes = new Hero[10];
        for (int i=0; i<10; i++){
            heroes[i] = new Hero(i);
        }

        File f = new File("./src/io/object_stream/heros.lol");
        try(
                //创建对象输出流
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos =new ObjectOutputStream(fos);
                //创建对象输入流
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois =new ObjectInputStream(fis);
                ) {
            for (Hero h: heroes){
                oos.writeObject(h);
            }

            for (int i = 0; i < 10; i++){
                Hero h = (Hero)ois.readObject();
                System.out.println("hero:" + h.num);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
