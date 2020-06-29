package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;
import	java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于生成源代码的工具类
 * @author Mr.Longyx
 * @date 2020年06月26日 22:11
 */
public class SpdbProxy {
    private static final String line = "\r\n";

    public static Object newProxyInstance(SpdbClassLoader loader,
                                          Class<?>[] interfaces,
                                          SpdbInvocationHandler h){
        try {
            /**
             * 动态生成源代码
             * @author Mr.Longyx
             * @date 2020/6/26 23:15
             * @param loader
             * @param interfaces
             * @param h
             * @return java.lang.Object
             */
            String src = generateSrc(interfaces);
            /**
             * 将Java文件输出到磁盘
             * @author Mr.Longyx
             * @date 2020/6/26 23:15
             * @param loader
             * @param interfaces
             * @param h
             * @return java.lang.Object
             */
            String filePath = SpdbProxy.class.getResource("").getPath();
            File file = new File(filePath+"$Proxy0.java");
            FileWriter writer = new FileWriter(file);
            writer.write(src);
            writer.flush();
            writer.close();

            /**
             * 结合代码动态编译
             * @author Mr.Longyx
             * @date 2020/6/26 23:26
             * @param loader
             * @param interfaces
             * @param h
             * @return java.lang.Object
             */
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);

            /**
             * 创建一个编译任务
             * @author Mr.Longyx
             * @date 2020/6/26 23:30
             * @param loader
             * @param interfaces
             * @param h
             * @return java.lang.Object
             */
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null,null,null,null);
            task.call();
            manager.close();

            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(SpdbInvocationHandler.class);

            return c.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;"+line);
        sb.append("import com.spdb.study.design.pattern.proxy.staticproxy.Person;"+line);
        sb.append("import java.lang.reflect.*;"+line);
        sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+line);

        sb.append("SpdbInvocationHandler h;"+line);
        sb.append("public $Proxy0(SpdbInvocationHandler h) {" + line);
            sb.append("this.h = h;"+line);
        sb.append("}" + line);


        /**
         * 结合反射根据接口生成方法
         * @author Mr.Longyx
         * @date 2020/6/26 22:43
         * @param interfaces
         * @return java.lang.String
         */
        for (Method m : interfaces[0].getMethods()){
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for(int i=0;i<params.length;i++){
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type+" "+paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName()+".class");
                if(i>0 && i<params.length-1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("@Override"+line);
            sb.append("public "+m.getReturnType().getName()+ " "+m.getName()+"() {"+line);
            sb.append("try {"+line);
                sb.append("Method m = "+interfaces[0].getName() + ".class.getMethod(\""+m.getName()+"\",new Class[]{"+paramClasses.toString()+"});"+line);
                sb.append("this.h.invoke(this,m,null);"+line);
                sb.append("}catch(Throwable e) {"+line);
                sb.append("e.printStackTrace();"+line);
                sb.append(getReturnEmptyCode(m.getReturnType()));
                sb.append("}"+line);
            sb.append("}");
        }
        sb.append("}");

        return sb.toString();
    }

    private static boolean hasReturn(Class<?> returnType) {
        return returnType != Void.class;
    }

    private static Map<Class,Class> mappings = new HashMap<>();
    static{
        mappings.put(int.class,Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if (mappings.containsKey(returnClass)){
            return "return 0";
        }else if (returnClass == Void.class){
            return "";
        }else{
            return "return null;";
        }
    }

    private static String getCaseCode(String code,Class<?> returnClass){
        if (mappings.containsKey(returnClass)){
            return "((" + mappings.get(returnClass).getName() + ")"+code + ")." + returnClass.getSimpleName();
        }
        return code;
    }

    private static String toLowerFirstCase(String simpleName) {
        char[] chs = simpleName.toCharArray();
        chs[0] += 32;
        return String.valueOf(chs);
    }

}
