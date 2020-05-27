package com.lihang.base.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: LI
 * Date: 2020/5/27
 */
public class Lambda {

    public static void main(String[] args){
    String[] atp = {"小猪佩奇","大象艾米莉","长颈鹿苏森"};
    List<String> users = Arrays.asList(atp);
    for (String user :users){
        System.out.println(user);
    }
    //lambda
    users.forEach(user -> System.out.println(user));

    //：：
    users.forEach(System.out::println);

    new Thread(()-> System.out.println("new "));
    }

}


