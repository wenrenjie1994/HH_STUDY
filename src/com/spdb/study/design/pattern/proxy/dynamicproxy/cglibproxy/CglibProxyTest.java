package com.spdb.study.design.pattern.proxy.dynamicproxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * JDK采用读取接口的信息
 * CGLIB覆盖父类方法
 * 目的：都是生成一个新的类，去实现增强代码逻辑的功能
 *
 * JDK Proxy：对于用户而言·，必须要有一个接口实现，目标类相对来说复杂一些
 * CGLIB:可以代理任意一个普通的类，没有任何要求
 *
 * CGLIB 生成代理逻辑更复杂，效率低，调用效率更高，生成一个包含了所有的逻辑的FastClass，不再需要反射调用
 * JDK Proxy: 生成代理的逻辑简单，执行效率相对较低，每次都要通过反射动态调用
 * CGLIB的坑：Cglib不能代理final的方法
 * @author Mr.Longyx
 * @date 2020年06月28日 0:47
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"F://cglib_proxy_classes");
            Customer customer = (Customer)new CglibMatchMaker().getInstance(Customer.class);
            customer.findTheHalf();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
