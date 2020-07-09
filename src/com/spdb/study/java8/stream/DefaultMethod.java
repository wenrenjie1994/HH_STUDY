package com.spdb.study.java8.stream;

/**
 * Stream中default method(解决多重继承冲突问题)
 * 1、Class优先级最高(重写了父类的方法)
 * 2、否则，子接口优先级最高
 * 3、最后，重写并显式调用优先级最高
 * @author Mr.Longyx
 * @date 2020年07月09日 12:54
 */
public class DefaultMethod {

    public static void main(String[] args) {
        /**
         * 此处调用参数更具体的方法
         * DefaultMethod defaultMethod = new DefaultMethod();
         * defaultMethod.confuse(null);
         * 即调用：
         * private void confuse(int[] ins){
         *        System.out.println("ins");
         * }
         *
         * 此处调用匹配度更大的方法
         * DefaultMethod defaultMethod = new DefaultMethod();
         * int[] ins = null;
         * Object obj = ins;
         * defaultMethod.confuse(obj);
         * 即调用：
         *  private void confuse(Object obj){
         *       System.out.println("obj");
         *  }
         * @author Mr.Longyx
         * @date 2020/7/9 13:06
         */

        MethodA a = new MethodC();
        a.hello();
    }

    private interface MethodA {
        default void hello(){
            System.out.println("hello methodA");;
        }
    }

    private interface MethodB{
        default void hello() {
            System.out.println("MethodB中重写MethodA");
        }
    }

    public static class MethodC implements MethodB,MethodA{

        @Override
        public void hello() {
            System.out.println("MethodC");
        }
    }
}
