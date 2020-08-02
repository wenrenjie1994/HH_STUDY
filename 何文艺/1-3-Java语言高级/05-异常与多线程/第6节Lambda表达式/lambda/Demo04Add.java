package lambda;

public class Demo04Add {
    public static void main(String[] args) {
        //匿名内部类
        invokeCalc(120, 130, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });
        //Lambda表达式
        invokeCalc(120, 130, (int a, int b) -> {
            return a + b;
        });
        //Lambda表达式省略优化
        invokeCalc(120, 130, (a, b) -> a + b);
    }

    private static void invokeCalc(int a, int b, Calculator calc) {
        int result = calc.calc(a, b);
        System.out.println("结果是：" + result);
    }
}
