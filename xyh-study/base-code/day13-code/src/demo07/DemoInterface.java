package demo07;
/*接口作为方法的参数*/
import java.util.ArrayList;
import java.util.List;
/*
* java.util.list 正是ArrayList所实现的接口。
* */
public class DemoInterface {
    public static void main(String[] args) {
        //左边是接口的名称，右边是实现类名称，这是多态的写法
        List<String> list=new ArrayList<>();
        List<String> result=addName(list);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }

    public static List<String> addName(List<String> list){
        list.add("dora");
        list.add("linda");
        list.add("tom");
        return list;

    }
}
