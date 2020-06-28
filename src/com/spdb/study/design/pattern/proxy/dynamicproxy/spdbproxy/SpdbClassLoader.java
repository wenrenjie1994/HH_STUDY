package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;
import	java.io.ByteArrayOutputStream;
import	java.io.FileInputStream;
import	java.io.File;

/**
 * @author Mr.Longyx
 * @date 2020年06月26日 22:14
 */
public class SpdbClassLoader extends ClassLoader{
    private File classPathFile;

    public SpdbClassLoader(){
        String classPath = SpdbClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
       String className = SpdbClassLoader.class.getPackage().getName()+"."+name;
       if (classPathFile != null){
           /**
            * 到类路径下找到使用程序自动生成的.java文件
            * @author Mr.Longyx
            * @date 2020/6/26 23:43
            * @param name
            * @return java.lang.Class<?>
            */
           File classFile = new File(classPathFile,name.replaceAll("\\.","/")+".class");
           if (classFile.exists()){
               FileInputStream in = null;
               ByteArrayOutputStream out = null;
               try {
                   in = new FileInputStream(classFile);
                   out = new ByteArrayOutputStream();
                   byte[] buff = new byte[1024];
                   int len;
                   while((len = in.read(buff)) != -1){
                       out.write(buff,0,len);
                   }
                   return defineClass(className,out.toByteArray(),0,out.size());
               }catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }
       return null;
    }
}
