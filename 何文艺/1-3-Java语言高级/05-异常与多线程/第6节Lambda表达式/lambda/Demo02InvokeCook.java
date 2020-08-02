package lambda;

public class Demo02InvokeCook {
    public static void main(String[] args) {
        //原始代码
        CookImplements c = new CookImplements();
        invokeCook(c);

        //匿名内部类简化代码
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭啦！");
            }
        });

        //Lambda表达式简化代码
        invokeCook(() -> {
            System.out.println("吃饭啦！");
        });

        //Lambda表达式省略优化
        invokeCook(() -> System.out.println("吃饭啦！"));
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
