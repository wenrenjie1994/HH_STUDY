package com.spdb.study.algorithm.queue;

import java.util.Stack;

/**
 * (Stack)用两个栈实现队列的功能
 * @author Mr.Longyx
 * @date 2020年06月20日 21:18
 */
public class CQueue2 {
    /**
     * stack1 入队，stack2 出队
     * @author Mr.Longyx
     * @date 2020/6/20 21:20
     */
    Stack<Integer> stack1,stack2;
    public CQueue2(){
        /**
         * 初始化 stack1,stack2
         * @author Mr.Longyx
         * @date 2020/6/20 21:19
         */
        stack1 = new Stack<>();
        stack2 = new Stack<> ();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int deleteHead(){
        /**
         * 如果stack2非空，依次弹出栈顶元素即可，否则，先将stack1中元素，压入stack2中，依次弹出stack2中栈顶元素
         * @author Mr.Longyx
         * @date 2020/6/20 21:23
         * @return int
         */
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.empty() ? -1 : stack2.pop();
        }
    }
}
