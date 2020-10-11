package com.longyx.study.design.pattern.chain.auth.builderchain;

import com.longyx.study.design.pattern.chain.auth.old.User;

/**
 * 责任链模式(权限验证框架中广泛使用，如Spring Security,Oauth2,Apache Shiro)
 * 优点：
 * 1、将请求与处理解耦
 * 2、请求处理者(节点对象)只需关注自己感兴趣的请求进行处理即可，对于不感兴趣的请求，直接转发给下一级节点对象
 * 3、具备链式传递处理请求功能，请求发送者无需知晓链路结构，只需等待请求处理结果
 * 4、链路结构灵活，可以通过改变链路结构动态地新增或删减责任
 * 5、易于扩展新的请求处理类，符合开闭原则
 * 缺点：
 * 1、责任链太长或者处理时间过长，会影响整体性能
 * 2、如果节点对象存在循环引用时，会造成死循环，导致系统崩溃
 * @author Mr.Longyx
 * @date 2020年07月10日 22:04
 */
public abstract class Handler<T> {
    protected Handler next;
    public void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(User user);

    public static class Builder<T>{
        private Handler<T> head;
        private Handler<T> tail;

        public Builder<T> addHandler(Handler handler){
            do {
                if (this.head == null){
                    this.head = this.tail = handler;
//                    return this;
                    break;
                }
                this.tail.next(handler);
                this.tail = handler;
            }while (head.next == null);//如果是双向链表，则要判断是否到链表尾
            return this;
        }

        public Handler<T> build(){
            return this.head;
        }
    }
}
