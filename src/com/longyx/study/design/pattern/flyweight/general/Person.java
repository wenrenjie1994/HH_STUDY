package com.spdb.study.design.pattern.flyweight.general;

/**
 * 享元模式适用场景：
 * 1、常常应用于系统底层的开发，以便解决系统的性能问题
 * 2、系统有大量相似对象、需要使用缓冲池的场景
 * 优点：
 * 1、减少对象的创建，降低内存中对象的数量，降低系统的内存，提高效率
 * 2、减少内存之外的其他资源占用
 * 缺点：
 *1、关注内、外部状态、关注线程安全问题
 *2、使系统、程序的逻辑复杂化
 * @author Mr.Longyx
 * @date 2020年07月05日 22:55
 */
public interface Person {
    void dailyTask(String task);
}
