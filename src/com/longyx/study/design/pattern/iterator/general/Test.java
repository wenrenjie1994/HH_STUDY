package com.longyx.study.design.pattern.iterator.general;

/**
 * @author Mr.Longyx
 * @date 2020年07月11日 11:24
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 创建一个容器对象
         * @author Mr.Longyx
         * @date 2020/7/11 11:24
         */
        Aggregate<String> aggregate = new ConcreteAggregate<>();
        /**
         * 添加元素
         * @author Mr.Longyx
         * @date 2020/7/11 11:25
         */
        aggregate.add("Java");
        aggregate.add("Python");
        aggregate.add("C++");
        aggregate.add("C");
        aggregate.add("go");


        /**
         * 获取容器对象迭代器
         * @author Mr.Longyx
         * @date 2020/7/11 11:26
         */
        Iterator<String> iterator = aggregate.iterator();
        /**
         * 遍历
         * @author Mr.Longyx
         * @date 2020/7/11 11:26
         */
        while (iterator.hashNext()){
            String ele = iterator.next();
            System.out.println(ele);
        }
    }
}
