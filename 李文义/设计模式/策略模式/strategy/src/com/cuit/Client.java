package com.cuit;

import com.cuit.context.Context;
import com.cuit.strategy.BackDoor;
import com.cuit.strategy.BlockEnemy;
import com.cuit.strategy.GivenGreenLight;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public class Client {
    public static void main(String[] args) {
        Context context;
        //刚刚到吴国的时候拆第一个
        System.out.println("---刚刚到吴国的时候拆第一个---");
        //拿到妙计
        context = new Context(new BackDoor());
        context.operate(); //拆开执行
        //刘备乐不思蜀了，拆第二个了
        System.out.println("---刘备乐不思蜀了，拆第二个了---");
        context = new Context(new GivenGreenLight());
        //执行了第二个锦囊
        context.operate();
        //孙权的小兵追来了，咋办？拆第三个
        System.out.println("---孙权的小兵追来了，咋办？拆第三个---");
        context = new Context(new BlockEnemy());
        //孙夫人退兵
        context.operate();
    }
}
