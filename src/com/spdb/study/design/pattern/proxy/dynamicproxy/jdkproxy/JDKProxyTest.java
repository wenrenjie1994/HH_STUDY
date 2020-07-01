package com.spdb.study.design.pattern.proxy.dynamicproxy.jdkproxy;
import	java.io.FileOutputStream;
import java.io.IOException;

import com.spdb.study.design.pattern.proxy.staticproxy.Person;
import sun.misc.ProxyGenerator;

/**
 * JDK动态代理的实现原理：
 * 1、拿到被代理类的引用，并且通过反射获取它的所有的接口
 * 2、JDK Proxy类重新生成一个新的类，实现了被代理类所有接口的方法
 * 3、动态生成Java代码，把增强的逻辑加入到新生成的代码中
 * 4、编译生成新的Java代码的class文件
 * 5、加载并重新运行新的class，得到的类是全新的类
 * @author Mr.Longyx
 * @date 2020年06月26日 21:44
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            Person person = (Person) new JDKMatchMaker().getInstance(new Girl());
            person.findLove();

            /**
             * 动态生成字节码
             * @author Mr.Longyx
             * @date 2020/6/26 21:59
             */
            byte[] bytes = ProxyGenerator.generateProxyClass("$proxy0",new Class[]{Person.class});
            fos = new FileOutputStream("F://$proxy0.class");
            fos.write(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
