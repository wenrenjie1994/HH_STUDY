package method;

import method.filter.ApplePredict;
import method.filter.PredicateAnything;
import method.filter.impl.AppleGreenColorPredict;
import method.filter.impl.AppleHeavyWeightPredict;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: A wei
 * @Date: 2020/6/23 17:51
 * @Last Modified by:
 * @last Modified date:
 * @Description: Lamda
 */
public class LambdaTest {

    public static void main(String[] args) {

        Apple apple1 = new Apple("green",150);
        Apple apple2 = new Apple("red",110);
        Apple apple3 = new Apple("green",130);

        List<Apple> appleList = new ArrayList<>();
        appleList.add(apple1);
        appleList.add(apple2);
        appleList.add(apple3);

        //Lambda表达式
        List<Apple> result = LambdaTest.filterApples(appleList,(Apple a)->"green".equals(a.getColor()));

        System.out.println(result);

        //Stream串行流
        List<Apple> heavyApple = appleList.stream().filter((Apple a) -> a.getWeight() > 130).collect(Collectors.toList());

        System.out.println("串行处理: " + heavyApple);

        //Stream并行流
        List<Apple> paraHeavyApple = appleList.parallelStream().filter((Apple a) -> a.getWeight() > 130).collect(Collectors.toList());

        System.out.println("并行处理: " + paraHeavyApple);

        //策略设计方式，定义接口，实现具体类,将具体类参数化传递
        List<Apple> weightPredictApple = LambdaTest.filterApples(appleList, new AppleHeavyWeightPredict());

        List<Apple> colorPredictApple = LambdaTest.filterApples(appleList,new AppleGreenColorPredict());

        //匿名类实现
        List<Apple> defaultPredictApple = LambdaTest.filterApples(appleList,new ApplePredict(){
            @Override
            public boolean predict(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });


        System.out.println(weightPredictApple);
        System.out.println(colorPredictApple);
        System.out.println(defaultPredictApple);


    }

    public static List<Apple> filterApples(List<Apple> appleList, ApplePredict applePredict){

        List<Apple> result = new ArrayList<>();

        for (Apple a : appleList){
            if (applePredict.predict(a)){
                 result.add(a);
            }
        }
        return result;
    }

    public static <T> List<T> filterAnything(List<T> ts, PredicateAnything predicateAnything){

        List<T> resultList = new ArrayList<>();

        for (T t1:ts){
            if (predicateAnything.predict(t1)){
                resultList.add(t1);
            }
        }
        return resultList;
    }



}
