package com.spdb.study.algorithm.queue;

import java.util.LinkedList;

/**
 * (LinkedList)用两个栈实现队列的功能
 * @author Mr.Longyx
 * @date 2020年06月20日 20:29
 */
public class CQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public CQueue(){
        /**
         * 初始化stack1 和 stack2
         * @author Mr.Longyx
         * @date 2020/6/20 20:31
         */
        stack1 = new LinkedList<Integer> ();
        stack2 = new LinkedList<Integer> ();
    }

    public void appendTail(int value){
        /**
         * 将元素放到 stack1 中
         * @author Mr.Longyx
         * @date 2020/6/20 20:33
         * @param value
         */
        stack1.addLast(value);
    }

    public int deleteHead(){
        /**
         * stack2 栈不为空，则返回栈顶元素
         * @author Mr.Longyx
         * @date 2020/6/20 20:39
         */
        if (!stack2.isEmpty()) {
            return stack2.removeLast();
        }

        /**
         * stack1 为空，直接返回-1
         * @author Mr.Longyx
         * @date 2020/6/20 20:41
         */
        if (stack1.isEmpty()){
            return -1;
        }

        /**
         * stack2 为空，stack1 不为空，将stack1中元素倒着放入stack2中
         * @author Mr.Longyx
         * @date 2020/6/20 20:41
         * @return int
         */
        while (!stack1.isEmpty()){
            stack2.addLast(stack1.removeLast());
        }

        /**
         * 返回 stack2 的栈顶元素
         * @author Mr.Longyx
         * @date 2020/6/20 20:44
         * @return int
         */
        return stack2.removeLast();
    }
}
