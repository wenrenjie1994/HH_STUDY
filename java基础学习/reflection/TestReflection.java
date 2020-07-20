package reflection;
/**
 * @Author: QiuhaoRan
 * @Description:
 * @Date: Created in 16:07 2020/5/22
 * @Modified By:
 */

public class TestReflection {

    public static void main(String[] args) {
        String className = "qiuhaoran_q1_reflection.Hero";
        try {
            //获取类对象的3种方式
            Class pClass1=Class.forName(className);
            Class pClass2=Hero.class;
            Class pClass3=new Hero().getClass();

            System.out.println(pClass1==pClass2);
            System.out.println(pClass1==pClass3);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread t1= new Thread(){
            public void run(){
                //调用method1
                TestReflection.method1();
            }
        };
        t1.setName("第一个线程");
        t1.start();

        //保证第一个线程先调用method1
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2= new Thread(){
            public void run(){
                //调用method2
                TestReflection.method2();
            }
        };
        t2.setName("第二个线程");
        t2.start();
    }

        public static void method1() {
            synchronized (TestReflection.class) {
                // 对于method1而言，同步对象是TestReflection.class，只有占用TestReflection.class才可以执行到这里
                System.out.println(Thread.currentThread().getName() + " 进入了method1方法");
                try {
                    System.out.println("运行5秒");
                    Thread.sleep(5000);//当前线程暂停
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }

        public static synchronized void method2(){
            // 对于mehotd2而言，必然有个同步对象，通过观察发现，当某个线程在method1中，占用了TestReflection.class之后
            // 就无法进入method2，推断出，method2的同步对象，就是TestReflection.class
            System.out.println(Thread.currentThread().getName() + " 进入了method2方法");
            try {
                System.out.println("运行5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }

        }
    }