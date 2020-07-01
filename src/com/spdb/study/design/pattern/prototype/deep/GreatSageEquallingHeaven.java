package com.spdb.study.design.pattern.prototype.deep;

import java.io.*;
import java.util.Date;

/**
 * 原型模式就是快速构建对象的方法总结
 * 简单工厂将getter、setter封装到某个方法中
 * JDK提供的实现Cloneable接口，实现快速复制
 * Spring中的配置scope="prototype",即应用原型模式，每次都会创建出新的实例
 * @author Mr.Longyx
 * @date 2020年06月25日 23:33
 */
public class GreatSageEquallingHeaven extends Monkey implements Cloneable, Serializable {
    private static final long serialVersionUID = 2905680991415113742L;
    public GoldenCudgel goldenCudgel;
    /**
     * 对象初始化
     * @author Mr.Longyx
     * @date 2020/6/25 23:47
     */
    public GreatSageEquallingHeaven(){
        this.birthday = new Date();
        this.goldenCudgel = new GoldenCudgel();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    private Object deepClone() {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            /**
             * 在内存中完成操作，对象读写：通过字节码的方式直接操作
             * @author Mr.Longyx
             * @date 2020/6/25 23:50
             * @return java.lang.Object
             */
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            /**
             * 创建完整的新对象 每次都会新new一个对象
             * @author Mr.Longyx
             * @date 2020/6/25 23:52
             * @return java.lang.Object
             */
            GreatSageEquallingHeaven copy = (GreatSageEquallingHeaven) ois.readObject();
            copy.birthday = new Date();

            return copy;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public GreatSageEquallingHeaven shallowClone(GreatSageEquallingHeaven target){
        GreatSageEquallingHeaven greatSageEquallingHeaven = new GreatSageEquallingHeaven();
        greatSageEquallingHeaven.height = target.height;
        greatSageEquallingHeaven.weight = target.weight;

        greatSageEquallingHeaven.goldenCudgel = target.goldenCudgel;
        greatSageEquallingHeaven.birthday = new Date();

        return greatSageEquallingHeaven;
    }
}
