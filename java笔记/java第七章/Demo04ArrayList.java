package basic.method.demo1.day2;

import java.util.ArrayList;

public class Demo04ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("赵");
        list.add("钱");
        list.add("孙");
        list.add("李");

        String name = list.get(2);
        System.out.println("第二号索引值为"+name);
        String whoRemoved = list.remove(3);
        System.out.println("谁被删除了"+whoRemoved);
        System.out.println(list);
    }
}
