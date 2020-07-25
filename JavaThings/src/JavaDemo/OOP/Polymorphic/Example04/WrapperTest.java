package JavaDemo.OOP.Polymorphic.Example04;

public class WrapperTest {
    public void test1() {
        Integer in1 = new Integer(12);
        int i1 = in1.intValue();
        System.out.println(i1 + 1);

        //自动拆箱
        System.out.println(in1.toString());
        int num = in1;

        Float f1 = new Float(1.23);
        float f = f1.floatValue();
        System.out.println(f + 1);
    }

    public void method(Object obj) {
        System.out.println(obj.toString());
    }

    //包装类、基本数据类型--->String类型
    public void test2() {
        int num2 = 10;

        //way1: linked
        String str1 = num2 + "";

        //call String.valueOf()
        float f1 = 12.34f;
        String str2 = String.valueOf(f1);

        Double d1 = new Double(23.45);
        String str3 = String.valueOf(d1);
        System.out.println(str2 + "\n" + str3);
    }

    //String类型--->基本数据类型、包装类，调用包装类的parseXXX()
    public void test3() {
        String str4 = "12345";
        /*
        //wrong
        int num3 = (int)str4;
        Integer = in2 = (Integer)str4;
         */

        int num4 = Integer.parseInt(str4);
        System.out.println(++num4);

        String str5 = "true";
        boolean b2 = Boolean.parseBoolean(str5);
        System.out.println(b2);
    }

    public void test4() {
        //三元运算符类型必须相同（自动提升）
        Object obj1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj1);           //1.0

        Object obj2;
        if (true) {
            obj2 = new Integer(1);
        } else {
            obj2 = new Double(2.0);
        }
        System.out.println(obj2);
    }

    public void test5() {
        Integer i = new Integer(1);
        Integer j = new Integer(2);
        System.out.println(i == j);

        /*
        Integer内部定义了IntegerCache结构，其定义了一个Integer[]
        Integer[]保存了-128~127，自动装箱的时候，可以直接使用Integer[]的数值
        不必再去new一个新数
         */
        Integer m = 1;
        Integer n = 1;
        System.out.println(m ==n);

        Integer x = 128;            //== new Integer(128)
        Integer y = 128;
        System.out.println(x == y);
    }

    public static void main(String[] args) {
        WrapperTest wt1 = new WrapperTest();
        wt1.test1();

        int num1 = 1988;
        wt1.method(new Integer(num1));

        //自动装箱
        wt1.method(num1);
        boolean b1 = true;
        Boolean b = b1;

        System.out.println("-----------");

        wt1.test2();

        wt1.test3();

        wt1.test4();

        wt1.test5();
    }
}
