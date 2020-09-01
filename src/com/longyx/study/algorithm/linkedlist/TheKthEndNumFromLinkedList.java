package com.spdb.study.algorithm.linkedlist;

/**
 * 输入一个链表，返回链表中倒数第k个节点
 * @author Mr.Longyx
 * @date 2020年07月10日 8:25
 */
public class TheKthEndNumFromLinkedList {
        static class ListNode{
            int val;
            ListNode next;
            ListNode(int x){
                val = x;
            }
        }

        /**
         * 常规解法
         * @author Mr.Longyx
         * @date 2020/7/10 9:02
         */
        public static ListNode getTheKthFromEnd(ListNode head, int k){
            if (head == null || k < 0){
                return null;
            }
            ListNode temp = head;
            int n = 0;
            while (head != null){
                n++;
                head = head.next;
            }

            for (int i=0;i<n-k;i++){
                temp = temp.next;
            }
            return temp;
        }

        /**
         * 快慢指针解法
         * GuardLine:
         * 1、输入head指针为Null,由于代码会试图访问空指针指向的内存，程序会崩溃
         * 2、输入以head为头节点的链表的节点总数少于k。由于在for循环中会在链表向前走k-1步，仍然会由于空指针造成崩溃
         * 3、输入的参数k为0或负数，同样会造成程序的崩溃
         * @author Mr.Longyx
         * @date 2020/7/10 9:02
         * @param head
         * @param k
         * @return com.spdb.study.algorithm.linkedlist.TheKthEndNumFromLinkedList.ListNode
         */
        public static ListNode getKthFromEnd(ListNode head, int k){
            if (null == head || k < 0) {
                return null;
            }

            /**
             * 初始化两个指针slow和fast,将其初始都指向链表头节点
             * @author Mr.Longyx
             * @date 2020/7/10 8:41
             * @param head
             * @param k
             * @return com.spdb.study.algorithm.linkedlist.TheKthEndNumFromLinkedList.ListNode
             */
            ListNode slow = head;
            ListNode fast = head;
            /**
             * fast指针先向前走k步
             * @author Mr.Longyx
             * @date 2020/7/10 8:43
             * @param head
             * @param k
             * @return com.spdb.study.algorithm.linkedlist.TheKthEndNumFromLinkedList.ListNode
             */
            for(int i=0;i<k;i++){
                /**
                 * 此处说明以head为头节点的链表节点总数小于k
                 * @author Mr.Longyx
                 * @date 2020/7/10 8:44
                 * @param head
                 * @param k
                 * @return com.spdb.study.algorithm.linkedlist.TheKthEndNumFromLinkedList.ListNode
                 */
                if (null == fast && i < k){
                    return null;
                }
                fast = fast.next;
            }

            /**
             * slow和fast指针同时向前移动，直到fast指针直线NULL
             * @author Mr.Longyx
             * @date 2020/7/10 8:46
             * @param head
             * @param k
             * @return com.spdb.study.algorithm.linkedlist.TheKthEndNumFromLinkedList.ListNode
             */
            while (fast != null){
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
}
